package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.Project;
import com.example.demo.mapper.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author okcgogogo
 * @date 2020/12/6 15:27
 */
@Service
@Slf4j
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService{

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    AsyncService asyncService;

    @Override
    public void saveProject(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public List<Project> getAllProject() {
        List<Project> list = this.list();
        log.info("getAllProject---");
        asyncService.sendMsg();
        log.info("getAllProject---return");
        return list;
    }

}
