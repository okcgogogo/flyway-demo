package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.demo.domain.Project;
import com.example.demo.service.ProjectService;
import com.example.demo.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.example.demo.domain.enums.ProjectStateEnum.PLANNED;

/**
 * @author xiangli.chen
 * @date 2020/12/6 14:42
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectMapperTest {

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ProjectService projectService;
    @Autowired
    RedisUtils redis;

    @Test
    public void testProjectMapper(){
        Project entity = new Project();
        entity.setId("111");
        entity.setCode("测试项目编码1");
        entity.setName("测试项目名称1");
        entity.setDescription("测试项目描述1");
        int insert = projectMapper.insert(entity);
        System.out.println("入库记录数" + insert);
    }

    @Test
    public void testProjectMapperEnum(){
        Project entity = new Project();
        entity.setId(IdWorker.getIdStr());
        entity.setCode("测试项目编码2");
        entity.setName("测试项目名称2");
        entity.setDescription("测试项目描述2");
        entity.setState(PLANNED);
        int insert = projectMapper.insert(entity);
        System.out.println("入库记录数:" + insert);
    }

    @Test
    public void testProjectMapperTableField(){
        Project entity = new Project();
        entity.setId("133");
        entity.setCode("测试项目编码133");
        entity.setName("测试项目名称133");
        int insert = projectMapper.insert(entity);
        System.out.println("入库记录数:" + insert);
    }

    @Test
    public void testUpdateProjectMapperTableField(){
        Project entity = projectMapper.selectById("120");
        entity.setName("测试项目名称120-5");
        int update = projectMapper.updateById(entity);
        System.out.println("修改记录数" + update);
    }

    @Test
    public void testUpdateProjectService(){
        Project entity = projectService.getById("122");
        entity.setName("测试项目名称122-3");
        projectService.updateById(entity);
        System.out.println("修改记录");
    }

    @Test
    public void testRedis(){
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("kkk","ttt", 10, TimeUnit.SECONDS);
        System.out.println(operations.get("kkk"));
    }

    @Test
    public void testObjectRedis(){
        String key = "testObject";
        List<Project> list = projectService.list();
        redis.set(key, list,  30L, TimeUnit.SECONDS);
        log.info("redis:{}", redis.get(key));
    }

    @Test
    public void testHashRedis(){
        String key = "testHash";
        List<Project> list = projectService.list();
        list.forEach(l -> redis.hSet(key, l.getId(), l));
        redis.expire(key, 20);

        List<Project> projectList = redis.hGetAll(key);
        projectList.forEach(p -> log.info("redis:[{}]",p.toString()));
    }

    @Test
    public void listProjectsByRedis(){
        List<Project> list = projectService.list();
        System.out.println("queryFromDB:" + list);
        redis.lPushList("projects", list);
        redis.expire("projects", 60);

        List<Project> projects = redis.lRange("projects", 0, -1);
        System.out.println("queryFromRedis:" + projects);
    }

    @Test
    public void listProjectsMap(){
        List<Map<String, Object>> maps = projectService.listMaps();
        System.out.println("listProjectsMap:" + maps);
    }
}
