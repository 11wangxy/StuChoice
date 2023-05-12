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
        log.info("\n前端查询页面请访问： http://localhost:8083/page.html");
    }
}
