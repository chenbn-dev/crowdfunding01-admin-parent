package cn.chenbonian.crowdfunding.service.api;

import cn.chenbonian.crowdfunding.entity.po.MemberPO;

/**
 * @author chbn
 * @create 2020-06-05 13:05
 */
public interface MemberService {
  MemberPO getMemberPOByLoginAcct(String loginacct);
}
