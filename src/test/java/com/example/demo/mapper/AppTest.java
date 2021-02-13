package com.example.demo.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author xiangli.chen
 * @date 2021/2/4 15:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {
    @Before
    public void init() {
        log.info("start test.......");
    }

    @After
    public void after() {
        log.info("end test.......");
    }
}
