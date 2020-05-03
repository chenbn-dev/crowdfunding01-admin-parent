package cn.chenbonian.crowdfunding.service.impl;

import cn.chenbonian.crowdfunding.entity.Admin;
import cn.chenbonian.crowdfunding.entity.AdminExample;
import cn.chenbonian.crowdfunding.mapper.AdminMapper;
import cn.chenbonian.crowdfunding.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author chbn
 * @create 2020-04-29 20:02
 */
@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  private AdminMapper adminMapper;

  @Override
  public List<Admin> getAll() {
    return adminMapper.selectByExample(new AdminExample());
  }

  @Override
  public void saveAdmin(Admin admin) {
    adminMapper.insert(admin);
  }
}
