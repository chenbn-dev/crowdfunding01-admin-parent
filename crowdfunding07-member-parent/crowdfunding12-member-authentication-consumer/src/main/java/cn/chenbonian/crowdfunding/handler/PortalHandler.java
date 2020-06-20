package cn.chenbonian.crowdfunding.handler;

import cn.chenbonian.crowdfunding.api.MySQLRemoteService;
import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import cn.chenbonian.crowdfunding.entity.vo.PortalTypeVO;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author chbn
 * @create 2020-06-06 9:36
 */
@Controller
public class PortalHandler {

  @Autowired private MySQLRemoteService mySQLRemoteService;

  //  @RequestMapping(value = "/", produces = "application/json;charset=utf-8")
  //  public String portal() {
  //    // 这里实际开发中需要加载数据，省略首页加载数据的操作
  //    return "portal";
  //  }

  @RequestMapping("/")
  public String showPortalPage(Model model) {

    // 1、调用MySQLRemoteService提供的方法查询首页要显示的数据
    ResultEntity<List<PortalTypeVO>> resultEntity =
        mySQLRemoteService.getPortalTypeProjectDataRemote();

    // 2.检查查询结果
    String result = resultEntity.getResult();
    if (ResultEntity.SUCCESS.equals(result)) {

      // 3.获取查询结果数据
      List<PortalTypeVO> list = resultEntity.getData();

      // 4.存入模型
      model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA, list);
    }

    return "portal";
  }
}
