package cn.chenbonian.crowdfunding.service.api;

import cn.chenbonian.crowdfunding.entity.vo.PortalTypeVO;
import cn.chenbonian.crowdfunding.entity.vo.ProjectVO;

import java.util.List;

/**
 * @author chbn
 * @create 2020-06-15 8:46
 */
public interface ProjectService {

  void saveProject(ProjectVO projectVO, Integer memberId);

  List<PortalTypeVO> getPortalTypeVO();
}
