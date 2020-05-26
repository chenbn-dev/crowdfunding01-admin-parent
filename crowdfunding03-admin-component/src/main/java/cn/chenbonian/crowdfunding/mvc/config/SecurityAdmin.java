package cn.chenbonian.crowdfunding.mvc.config;

import cn.chenbonian.crowdfunding.entity.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * 考虑到User对象中仅仅包含账号和密码，为了能够获取到原始的Admin对象，专门创建这个类对User类进行扩展
 *
 * @author chbn
 * @create 2020-05-25 23:00
 */
public class SecurityAdmin extends User {

  // 原始的Admin对象，包含Admin对象的全部属性
  private Admin originalAdmin;

  public SecurityAdmin(
      // 传入原始的Admin对象
      Admin originalAdmin,
      // 传入角色权限信息的集合
      List<GrantedAuthority> authorities) {
    // 调用父类的构造器
    super(originalAdmin.getLoginAcct(), originalAdmin.getUserPswd(), authorities);
    this.originalAdmin = originalAdmin;
  }
  // 对外提供的获取原始Admin对象的get方法
  public Admin getOriginalAdmin() {
    return originalAdmin;
  }
}
