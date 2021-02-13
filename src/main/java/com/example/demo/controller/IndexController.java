package com.example.demo.controller;

import com.example.demo.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiangli.chen
 * @date 2020/11/29 0:03
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class IndexController {
    @Autowired
    AsyncService asyncService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/test1")
    public String asyncRequest(){
        log.info("controller--start");
        asyncService.sendMsg();
        log.info("controller--end");
        return "异步测试";
    }
}
