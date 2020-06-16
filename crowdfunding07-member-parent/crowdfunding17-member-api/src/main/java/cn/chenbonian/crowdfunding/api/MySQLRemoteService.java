package cn.chenbonian.crowdfunding.api;

import cn.chenbonian.crowdfunding.entity.po.MemberPO;
import cn.chenbonian.crowdfunding.entity.vo.ProjectVO;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chbn
 * @create 2020-06-05 12:52
 */
@FeignClient("mysql-provider-2000")
public interface MySQLRemoteService {

  @RequestMapping("/save/member/remote")
  ResultEntity<String> saveMember(@RequestBody MemberPO memberPO);

  @RequestMapping("/get/memberpo/by/login/acct/remote")
  ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct);

  @RequestMapping("/save/project/vo/remote")
  ResultEntity<String> saveProjectVORemote(
      @RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId);
}
