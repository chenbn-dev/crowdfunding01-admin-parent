package cn.chenbonian.crowdfunding.service.api;

import cn.chenbonian.crowdfunding.entity.Admin;

import java.util.List;

/**
 * Admin业务层接口
 *
 * @author chbn
 * @create 2020-04-29 20:01
 */
public interface AdminService {

  void saveAdmin(Admin admin);

  List<Admin> getAll();

  Admin getAdminByLoginAcct(String loginAcct, String userPswd);
}
