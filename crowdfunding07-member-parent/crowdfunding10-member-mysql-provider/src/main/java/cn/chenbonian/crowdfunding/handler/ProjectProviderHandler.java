package cn.chenbonian.crowdfunding.handler;

import cn.chenbonian.crowdfunding.entity.vo.DetailProjectVO;
import cn.chenbonian.crowdfunding.entity.vo.PortalTypeVO;
import cn.chenbonian.crowdfunding.entity.vo.ProjectVO;
import cn.chenbonian.crowdfunding.service.api.ProjectService;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chbn
 * @create 2020-06-15 8:45
 */
@RestController
public class ProjectProviderHandler {
  @Autowired ProjectService projectService;

  @RequestMapping("/get/project/detail/remote/{projectId}")
  public ResultEntity<DetailProjectVO> getDetailProjectVORemote(
      @PathVariable("projectId") Integer projectId) {
    try {
      DetailProjectVO detailProjectVO = projectService.getDetailProjectVO(projectId);
      return ResultEntity.successWithData(detailProjectVO);
    } catch (Exception e) {
      e.printStackTrace();
      return ResultEntity.failed(e.getMessage());
    }
  }

  @RequestMapping("/get/portal/type/project/data/remote")
  public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote() {

    try {
      List<PortalTypeVO> portalTypeVOList = projectService.getPortalTypeVO();

      return ResultEntity.successWithData(portalTypeVOList);
    } catch (Exception e) {
      e.printStackTrace();

      return ResultEntity.failed(e.getMessage());
    }
  }

  @RequestMapping("/save/project/vo/remote")
  public ResultEntity<String> saveProjectVORemote(
      @RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId) {

    try {
      // 调用“本地”Service执行保存
      projectService.saveProject(projectVO, memberId);

      return ResultEntity.successWithoutData();
    } catch (Exception e) {
      e.printStackTrace();
      return ResultEntity.failed(e.getMessage());
    }
  }
}
