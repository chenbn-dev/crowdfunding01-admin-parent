package cn.chenbonian.crowdfunding.service.api;

import cn.chenbonian.crowdfunding.entity.Menu;

import java.util.List;

/**
 * @author chbn
 * @create 2020-05-14 23:58
 */
public interface MenuService {

  void removeMenu(Integer id);

  void updateMenu(Menu menu);

  void saveMenu(Menu menu);

  List<Menu> getAll();
}
