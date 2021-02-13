package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.domain.Project;

import java.util.List;

/**
 * @author xiangli.chen
 * @date 2020/12/6 15:26
 */
public interface ProjectService extends IService<Project> {
    void saveProject(Project project);

    List<Project> getAllProject();

}
