package com.example.demo.quartz;

import com.example.demo.domain.Project;
import com.example.demo.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiangli.chen
 * @date 2021/1/19 14:13
 */
@Service
@Slf4j
public class ProjectTimer {
    @Autowired
    private ProjectService projectService;

    // @Scheduled(cron = "0/30 * * * * ?")
    @Scheduled(cron = "0 0 14 * * ?")
    public void getProjects(){
        List<Project> allProject = projectService.list();
        log.info("Quartz---allProject:{}", allProject);
    }

}
