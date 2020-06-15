package cn.chenbonian.crowdfunding.handler;

import cn.chenbonian.crowdfunding.service.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chbn
 * @create 2020-06-15 8:45
 */
@RestController
public class ProjectProviderHandler {
  @Autowired ProjectService projectService;
}
