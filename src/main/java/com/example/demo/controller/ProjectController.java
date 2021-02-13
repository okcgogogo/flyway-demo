package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.demo.domain.Project;
import com.example.demo.param.ProjectParam;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.demo.domain.enums.ProjectStateEnum.PLANNED;

/**
 * @author xiangli.chen
 * @date 2020/12/6 15:28
 */
@RestController
@RequestMapping("/demo")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/save/{id}")
    public String save(@PathVariable("id") String id){
        Project entity = new Project();
        entity.setId(IdWorker.getIdStr());
        entity.setCode("测试项目编码" + id);
        entity.setName("测试项目名称" + id);
        entity.setDescription("测试项目描述" + id);
        entity.setState(PLANNED);
        projectService.saveProject(entity);
        System.out.println("请求成功");
        return "hi";
    }

    @GetMapping("/kiki")
    public String get(@RequestParam String id){
        System.out.println(id);
        return "hello";
    }

    @PostMapping("/postTest")
    public ProjectParam testPost(@RequestBody ProjectParam projectParam){
        System.out.println(projectParam);
        return projectParam;
    }

    @GetMapping("/getAllProject")
    public List<Project> getAllProject(){
        return projectService.getAllProject();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") String id){
        return projectService.getById(id);
    }


}
