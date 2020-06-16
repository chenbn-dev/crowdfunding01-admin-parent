package cn.chenbonian.crowdfunding.handler;

import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import cn.chenbonian.crowdfunding.entity.po.MemberPO;
import cn.chenbonian.crowdfunding.entity.vo.ProjectVO;
import cn.chenbonian.crowdfunding.service.api.MemberService;
import cn.chenbonian.crowdfunding.service.api.ProjectService;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chbn
 * @create 2020-06-05 13:01
 */
@RestController
public class MemberProviderHandler {
  @Autowired private MemberService memberService;
  @Autowired private ProjectService projectService;

  @RequestMapping("/save/project/vo/remote")
  public ResultEntity<String> saveProjectVORemote(
      @RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId) {
    try {
      // 调用“本地”Service 执行保存
      projectService.saveProject(projectVO, memberId);
      return ResultEntity.successWithoutData();
    } catch (Exception e) {
      e.printStackTrace();
      return ResultEntity.failed(e.getMessage());
    }
  }

  @RequestMapping("/save/member/remote")
  public ResultEntity<String> saveMember(@RequestBody MemberPO memberPO) {
    try {
      memberService.saveMember(memberPO);
      return ResultEntity.successWithoutData();
    } catch (Exception e) {
      if (e instanceof DuplicateKeyException) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
      }
      return ResultEntity.failed(e.getMessage());
    }
  }

  @RequestMapping("/get/memberpo/by/login/acct/remote")
  public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(
      @RequestParam("loginacct") String loginacct) {
    try {
      // 1.调用本地 Service 完成查询
      MemberPO memberPO = memberService.getMemberPOByLoginAcct(loginacct);
      // 2.如果没有抛异常，那么就返回成功的结果
      return ResultEntity.successWithData(memberPO);
    } catch (Exception e) {
      e.printStackTrace();
      // 3.如果捕获到异常则返回失败的结果
      return ResultEntity.failed(e.getMessage());
    }
  }
}
