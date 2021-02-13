package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * implements ApplicationRunner
 * 可以重写run方法，启动后直接运行
 */
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@EnableAsync
@EnableScheduling
public class FlywayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlywayDemoApplication.class, args);
	}


}
