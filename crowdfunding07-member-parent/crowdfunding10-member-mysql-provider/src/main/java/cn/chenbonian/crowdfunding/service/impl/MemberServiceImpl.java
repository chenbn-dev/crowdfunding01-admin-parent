package cn.chenbonian.crowdfunding.service.impl;

import cn.chenbonian.crowdfunding.entity.po.MemberPO;
import cn.chenbonian.crowdfunding.entity.po.MemberPOExample;
import cn.chenbonian.crowdfunding.mapper.MemberPOMapper;
import cn.chenbonian.crowdfunding.service.api.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chbn
 * @create 2020-06-05 13:05
 */
@Service
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
  @Resource private MemberPOMapper memberPOMapper;

  @Override
  public MemberPO getMemberPOByLoginAcct(String loginacct) {
    // 1.创建 Example 对象
    MemberPOExample example = new MemberPOExample();
    // 2.创建 Criteria 对象
    MemberPOExample.Criteria criteria = example.createCriteria();
    // 3.封装查询条件
    criteria.andLoginacctEqualTo(loginacct);
    // 4.执行查询
    List<MemberPO> list = memberPOMapper.selectByExample(example);
    // 5.获取结果
    return list.get(0);
  }

  @Override
  @Transactional(
      propagation = Propagation.REQUIRES_NEW,
      rollbackFor = Exception.class,
      readOnly = false)
  public void saveMember(MemberPO memberPO) {
    memberPOMapper.insertSelective(memberPO);
  }
}
