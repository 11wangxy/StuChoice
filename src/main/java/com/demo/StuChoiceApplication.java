package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class StuChoiceApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(StuChoiceApplication.class, args);
        Thread.sleep(20);
        log.info("让学生请吃饭： http://localhost:8083/tbs");
        log.info("让老师请吃饭： http://localhost:8083/tbt");
        log.info("学生上课： http://localhost:8083/status");
        log.info("请老师吃饭： http://localhost:8083/tt");
        log.info("请学生吃饭： http://localhost:8083/ts");
    }
}
