package cn.chenbonian.crowdfunding.handler;

import cn.chenbonian.crowdfunding.entity.po.MemberPO;
import cn.chenbonian.crowdfunding.service.api.MemberService;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
