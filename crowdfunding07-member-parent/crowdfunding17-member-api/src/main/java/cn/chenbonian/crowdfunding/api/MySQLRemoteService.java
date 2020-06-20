package cn.chenbonian.crowdfunding.api;

import cn.chenbonian.crowdfunding.entity.po.MemberPO;
import cn.chenbonian.crowdfunding.entity.vo.*;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

  @RequestMapping("/get/portal/type/project/data/remote")
  public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote();

  @RequestMapping("/get/project/detail/remote/{projectId}")
  public ResultEntity<DetailProjectVO> getDetailProjectVORemote(
      @PathVariable("projectId") Integer projectId);

  @RequestMapping("/get/order/project/vo/remote")
  ResultEntity<OrderProjectVO> getOrderProjectVORemote(
      @RequestParam("projectId") Integer projectId, @RequestParam("returnId") Integer returnId);

  @RequestMapping("/get/address/vo/remote")
  ResultEntity<List<AddressVO>> getAddressVORemote(@RequestParam("memberId") Integer memberId);

  @RequestMapping("/save/address/remote")
  ResultEntity<String> saveAddressRemote(@RequestBody AddressVO addressVO);
}
