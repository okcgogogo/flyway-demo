package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author okcgogogo
 * @date 2021/1/15 17:25
 */
@Configuration
public class AsyncThreadPoolConfig {

    @Bean
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor taskexecutor = new ThreadPoolTaskExecutor();
        taskexecutor.setCorePoolSize(10);
        taskexecutor.setMaxPoolSize(200);
        taskexecutor.setQueueCapacity(25);
        taskexecutor.setKeepAliveSeconds(200);
        taskexecutor.setThreadNamePrefix("my task-");
        taskexecutor.setAwaitTerminationSeconds(60);


        // 线程池对拒绝任务的处理策略
        // CallerRunsPolicy：由调用线程（提交任务的线程）处理该任务
        taskexecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        taskexecutor.initialize();
        return taskexecutor;
    }

}
