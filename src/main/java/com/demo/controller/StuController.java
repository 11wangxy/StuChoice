package com.demo.controller;

import com.demo.entity.Result;
import com.demo.service.StudentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class StuController {

    @Resource
    private StudentService studentService;


    @PostMapping("/save/{count}")
    public Result<String> saveStu(@PathVariable Integer count) {
        if (count == null) { // 如果 count 为空
            return Result.error("学生数量的值不能为空");
        }
        studentService.deleteData();
        log.info("删除数据成功");
        studentService.insert(count);
        return Result.success("插入数据成功");
    }

    @GetMapping("/tbt")
    public Result<List<String>> StuTByT() {
        List<String> strings = studentService.treatByT();
        log.info("查询让老师请吃饭的学生个数成功");
        return Result.success(strings);
    }

    @GetMapping("/tbs")
    public Result<List<String>> StuTByS() {
        List<String> strings = studentService.treatByS();
        log.info("查询让学生请吃饭的学生个数成功");
        return Result.success(strings);
    }

    @GetMapping("/tt")
    public Result<List<String>> StuTT() {
        List<String> strings = studentService.treatT();
        log.info("查询请老师吃饭的学生个数成功");
        return Result.success(strings);
    }

    @GetMapping("/ts")
    public Result<List<String>> StuTS() {
        List<String> strings = studentService.treatS();
        log.info("查询请学生吃饭的学生个数成功");
        return Result.success(strings);
    }

    @GetMapping("/status")
    public Result<List<String>> status() {
        List<String> lecture = studentService.lacture();
        log.info("查询上课的学生个数成功");
        return Result.success(lecture);
    }
}
