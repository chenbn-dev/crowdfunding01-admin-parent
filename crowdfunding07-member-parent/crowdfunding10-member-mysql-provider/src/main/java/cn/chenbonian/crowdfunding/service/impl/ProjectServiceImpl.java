package cn.chenbonian.crowdfunding.service.impl;

import cn.chenbonian.crowdfunding.service.api.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chbn
 * @create 2020-06-15 8:46
 */
@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {}
