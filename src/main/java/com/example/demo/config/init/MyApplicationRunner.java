package com.example.demo.config.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * springboot项目启动之后执行run方法
 * @author okcgogogo
 * @date 2021/2/4 18:19
 */
@Slf4j
@Component
@Order(value = 1)
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("----MyApplicationRunner----init--");
    }
}
