package com.example.demo.config.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * PostConstruct是在依赖注入之后执行
 * 初始化之后的callback
 * @author xiangli.chen
 * @date 2021/2/4 18:18
 */
@Slf4j
@Component
public class InitBean {

    @PostConstruct
    public void init(){
      log.info("----PostConstruct----init--");
    }
}
