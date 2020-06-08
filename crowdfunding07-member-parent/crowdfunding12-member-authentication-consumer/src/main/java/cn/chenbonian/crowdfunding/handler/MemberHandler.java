package cn.chenbonian.crowdfunding.handler;

import cn.chenbonian.crowdfunding.api.RedisRemoteService;
import cn.chenbonian.crowdfunding.config.ShortMessageProperties;
import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import cn.chenbonian.crowdfunding.util.CrowdUtil;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @author chbn
 * @create 2020-06-08 8:18
 */
@Controller
public class MemberHandler {
  @Autowired private ShortMessageProperties shortMessageProperties;
  @Autowired private RedisRemoteService redisRemoteService;

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
