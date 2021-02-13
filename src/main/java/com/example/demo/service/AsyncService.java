package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author xiangli.chen
 * @date 2021/1/15 17:04
 */
@Service
@Slf4j
public class AsyncService {

    @Async
    public void sendMsg(){
        log.info("sengMsg---start");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {

        }
        log.info("sengMsg---end");
    }
}
