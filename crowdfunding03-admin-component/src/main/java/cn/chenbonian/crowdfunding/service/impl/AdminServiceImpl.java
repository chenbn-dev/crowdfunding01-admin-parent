package cn.chenbonian.crowdfunding.service.impl;

import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import cn.chenbonian.crowdfunding.entity.Admin;
import cn.chenbonian.crowdfunding.entity.AdminExample;
import cn.chenbonian.crowdfunding.exception.LoginAcctAlreadyInUseException;
import cn.chenbonian.crowdfunding.exception.LoginAcctAlreadyInUseForUpdateException;
import cn.chenbonian.crowdfunding.exception.LoginFailedException;
import cn.chenbonian.crowdfunding.mapper.AdminMapper;
import cn.chenbonian.crowdfunding.service.api.AdminService;
import cn.chenbonian.crowdfunding.util.CrowdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Admin业务层实现类
 *
 * @author chbn
 * @create 2020-04-29 20:02
 */
@Service
public class AdminServiceImpl implements AdminService {

  @Autowired private AdminMapper adminMapper;

  private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

  @Override
  public void update(Admin admin) {
    // “Selective”表示有选择的更新，对于null值的字段不更新
    try {
      adminMapper.updateByPrimaryKeySelective(admin);
    } catch (Exception e) {
      e.printStackTrace();
      logger.info("异常全类名=" + e.getClass().getName());
      if (e instanceof DuplicateKeyException) {
        throw new LoginAcctAlreadyInUseForUpdateException(
            CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
      }
    }
  }

  @Override
  public Admin getAdminById(Integer adminId) {
    return adminMapper.selectByPrimaryKey(adminId);
  }

  @Override
  public void saveAdmin(Admin admin) {
    // 1.密码加密
    String userPswd = admin.getUserPswd();
    userPswd = CrowdUtil.md5(userPswd);
    admin.setUserPswd(userPswd);
    // 2.生成创建时间
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String createTime = format.format(date);
    admin.setCreateTime(createTime);

    // 3.执行保存
    try {
      adminMapper.insert(admin);
    } catch (Exception e) {
      e.printStackTrace();
      logger.info("异常全类名=" + e.getClass().getName());
      if (e instanceof DuplicateKeyException) {
        throw new LoginAcctAlreadyInUseException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
      }
    }
  }

  @Override
  public void remove(Integer adminId) {
    adminMapper.deleteByPrimaryKey(adminId);
  }

  @Override
  public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
    // 1.调用PageHelper的静态方法开启分页功能
    // 这里就充分体现了PageHelper的“非侵入式”设计，原本要做的查询不必有任何修改
    PageHelper.startPage(pageNum, pageSize);
    // 2.执行查询
    List<Admin> list = adminMapper.selectAdminByKeyword(keyword);
    // 3.封装到PageInfo对象中
    return new PageInfo<>(list);
  }

  @Override
  public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {
    // 1.根据登录账号查询admin对象
    // ① 创建AdminExample对象
    AdminExample adminExample = new AdminExample();
    // ② 创建Criteria对象
    AdminExample.Criteria criteria = adminExample.createCriteria();
    // ③ 在Criteria对象中封装查询条件
    criteria.andLoginAcctEqualTo(loginAcct);
    // ④ 调用adminMapper的方法执行查询
    List<Admin> list = adminMapper.selectByExample(adminExample);
    // 2.判断Admin对象是否为null
    if (list == null || list.size() == 0) {
      throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED_NO_SUSH_USER);
    }
    if (list.size() > 1) {
      new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
    }
    // 3.如果admin为null则抛出异常
    Admin admin = list.get(0);
    if (admin == null) {
      throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED_NO_SUSH_USER);
    }
    // 4.如果admin对象不为null则将数据库密码从admin对象中取出
    String userPswdDB = admin.getUserPswd();
    // 5.将表单提交的明文密码进行加密
    String userPswdForm = CrowdUtil.md5(userPswd);
    // 6.对密码进行比较
    if (!Objects.equals(userPswdDB, userPswdForm)) {
      // 7.如果比较结果不一致则抛出异常
      throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED_WRONG_PASSWORD);
    }
    // 8.如果一致则返回Admin对象
    return admin;
  }

  @Override
  public List<Admin> getAll() {
    return adminMapper.selectByExample(new AdminExample());
  }
}
