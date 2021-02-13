package com.example.demo.controller;

import com.example.demo.service.TestAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiangli.chen
 * @date 2021/1/5 11:12
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private TestAsyncService testAsyncService;

    @GetMapping("test")
    public String test(){
        log.info("threadName:" + Thread.currentThread().getName());
        testAsyncService.testService();
        log.info("threadName:" + Thread.currentThread().getName() + " 执行完成，返回响应");
        return "返回响应";
    }
}
