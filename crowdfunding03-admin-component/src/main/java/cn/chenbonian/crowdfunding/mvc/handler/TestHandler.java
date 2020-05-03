package cn.chenbonian.crowdfunding.mvc.handler;

import cn.chenbonian.crowdfunding.entity.Admin;
import cn.chenbonian.crowdfunding.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author chbn
 * @create 2020-05-03 20:55
 */

@Controller
public class TestHandler {

    @Autowired private AdminService adminService;

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap){
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList",adminList);
        return "target";
    }
}
