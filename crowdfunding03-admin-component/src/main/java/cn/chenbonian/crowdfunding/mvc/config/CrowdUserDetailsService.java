package cn.chenbonian.crowdfunding.mvc.config;

import cn.chenbonian.crowdfunding.entity.Admin;
import cn.chenbonian.crowdfunding.entity.Role;
import cn.chenbonian.crowdfunding.service.api.AdminService;
import cn.chenbonian.crowdfunding.service.api.AuthService;
import cn.chenbonian.crowdfunding.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chbn
 * @create 2020-05-25 23:11
 */
@Component
public class CrowdUserDetailsService implements UserDetailsService {

  @Autowired private AdminService adminService;
  @Autowired private RoleService roleService;
  @Autowired private AuthService authService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // 1.根据账号名称去查询Admin对象
    Admin admin = adminService.getAdminByLoginAcct(username);
    // 2.获取AdminId
    Integer adminId = admin.getId();
    // 3.根据adminId查询角色信息
    List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
    // 4. 根据adminId查询权限信息
    List<String> authNameList = authService.getAssignAuthNameByAdminId(adminId);
    // 5.创建集合的对象用来存储GrantedAuthority
    List<GrantedAuthority> authorities = new ArrayList<>();
    // 6.遍历assignedRoleList存入角色信息
    for (Role role : assignedRoleList) {
      // 注意：不要忘了加前缀
      String roleName = "ROLE_" + role.getName();
      SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);
      authorities.add(simpleGrantedAuthority);
    }
    // 7.遍历authNameList存入权限信息
    for (String authName : authNameList) {
      SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authName);
      authorities.add(simpleGrantedAuthority);
    }
    // 8.封装SecurityAdmin对象
    SecurityAdmin securityAdmin = new SecurityAdmin(admin, authorities);
    return securityAdmin;
  }
}
