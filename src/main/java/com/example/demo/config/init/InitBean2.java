package com.example.demo.config.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * InitializingBean也是在依赖注入之后执行
 * @author xiangli.chen
 * @date 2021/2/4 18:18
 */
@Slf4j
@Component
public class InitBean2 implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("----InitializingBean----init--");
    }
}
