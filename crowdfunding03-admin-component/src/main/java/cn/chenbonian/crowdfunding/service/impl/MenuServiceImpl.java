package cn.chenbonian.crowdfunding.service.impl;

import cn.chenbonian.crowdfunding.entity.Menu;
import cn.chenbonian.crowdfunding.entity.MenuExample;
import cn.chenbonian.crowdfunding.mapper.MenuMapper;
import cn.chenbonian.crowdfunding.service.api.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chbn
 * @create 2020-05-14 23:58
 */
@Service
public class MenuServiceImpl implements MenuService {

  @Autowired private MenuMapper menuMapper;

  @Override
  public void removeMenu(Integer id) {
    menuMapper.deleteByPrimaryKey(id);
  }

  @Override
  public void updateMenu(Menu menu) {
    // 由于pid没有传入，一定要使用有选择的更新，保证“pid”不会被置空
    menuMapper.updateByPrimaryKeySelective(menu);
  }

  @Override
  public void saveMenu(Menu menu) {
    menuMapper.insert(menu);
  }

  @Override
  public List<Menu> getAll() {
    return menuMapper.selectByExample(new MenuExample());
  }
}
