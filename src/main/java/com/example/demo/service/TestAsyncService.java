package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author xiangli.chen
 * @date 2021/1/5 11:16
 */
@Service
@Slf4j
public class TestAsyncService {

    @Async
    public void testService(){
        Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9,10}).forEach(t -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           log.info(Thread.currentThread().getName()+"--获取number为:" + t); ;
        });
    }
}
