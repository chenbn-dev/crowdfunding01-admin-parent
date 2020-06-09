package cn.chenbonian.crowdfunding.handler;

import cn.chenbonian.crowdfunding.api.MySQLRemoteService;
import cn.chenbonian.crowdfunding.api.RedisRemoteService;
import cn.chenbonian.crowdfunding.config.ShortMessageProperties;
import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import cn.chenbonian.crowdfunding.entity.po.MemberPO;
import cn.chenbonian.crowdfunding.entity.vo.MemberVO;
import cn.chenbonian.crowdfunding.util.CrowdUtil;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author chbn
 * @create 2020-06-08 8:18
 */
@Controller
public class MemberHandler {
  @Autowired private ShortMessageProperties shortMessageProperties;
  @Autowired private RedisRemoteService redisRemoteService;
  @Autowired private MySQLRemoteService mySQLRemoteService;

  @RequestMapping("auth/do/member/register")
  public String register(MemberVO memberVO, ModelMap modelMap) {
    // 获取用户输入的手机号
    String phoneNum = memberVO.getPhoneNum();
    // 拼redis中存储验证码的key
    String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
    // 从redis读取key对应的value
    ResultEntity<String> resultEntity = redisRemoteService.getRedisStringValueByKeyRemote(key);
    // 检查查询操作是否有效
    String result = resultEntity.getResult();
    if (ResultEntity.FAILED.equals(result)) {
      modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getMessage());
      return "member-reg";
    }
    String redisCode = resultEntity.getData();
    if (redisCode == null) {
      modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_NOT_EXISTS);
      return "member-reg";
    }
    // 如果从redis能够查询到value，则比较表单的验证码和redis验证码
    String formCode = memberVO.getCode();
    if (!Objects.equals(redisCode, formCode)) {
      modelMap.addAttribute(
          CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_NOT_INVALID);
    }
    // 如果验证码一致，则从redis删除
    //    redisRemoteService.removeRedisKeyRemote(key);//测试注册功能时因为没有短信验证，先注释掉，正式环境需要打开
    //    ResultEntity<String> removeResultEntity = redisRemoteService.removeRedisKeyRemote(key);
    //    if (ResultEntity.FAILED.equals(removeResultEntity.getResult())) {
    //     //如果删除失败，则尝试重新删除一次，若再次删除依旧失败，则不在进行删除，记录到日志中，人工去处理
    //      return "";
    //    }
    // 执行密码加密
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String usrepswdBeforeEncode = memberVO.getUserpswd();
    String usrepswdAfterEncode = passwordEncoder.encode(usrepswdBeforeEncode);
    memberVO.setUserpswd(usrepswdAfterEncode);
    // 执行保存
    // 创建MemberPO对象
    MemberPO memberPO = new MemberPO();
    // 复制属性
    BeanUtils.copyProperties(memberVO, memberPO);
    // 调用远程的方法
    ResultEntity<String> saveMemberResultEntity = mySQLRemoteService.saveMember(memberPO);
    if (ResultEntity.FAILED.equals(saveMemberResultEntity.getResult())) {
      modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveMemberResultEntity.getMessage());
      return "member-reg";
    }

    return "member-login";
  }

  @ResponseBody
  @RequestMapping("auth/member/send/short/message.json")
  public ResultEntity<String> sendMessage(@RequestParam("phoneNum") String phoneNum) {
    // 1.发送验证码到phoneName手机
    ResultEntity<String> sendMessageResultEntity =
        CrowdUtil.sendCodeByShortMessage(
            shortMessageProperties.getHost(),
            shortMessageProperties.getPath(),
            shortMessageProperties.getMethod(),
            phoneNum,
            shortMessageProperties.getAppCode(),
            shortMessageProperties.getSign(),
            shortMessageProperties.getSkin());
    // 2.判断短信发送的结果
    if (ResultEntity.SUCCESS.equals(sendMessageResultEntity.getResult())) {
      // 3.如果发送成功，将验证码存入redis
      // 从上一步操作的结果中获取随机生成的验证码
      String code = sendMessageResultEntity.getData();
      // 拼接一个用于在redis中存储数据的key
      String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
      // 调用远程接口存入redis
      ResultEntity<String> saveCodeResultEntity =
          redisRemoteService.setRedisKeyValueRemoteWithTimeout(key, code, 15, TimeUnit.MINUTES);
      // 判断结果
      if (ResultEntity.SUCCESS.equals(saveCodeResultEntity.getResult())) {

        return ResultEntity.successWithoutData();
      } else {
        return saveCodeResultEntity;
      }
    } else {
      return sendMessageResultEntity;
    }
  }
}
