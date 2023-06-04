package com.demo.service;

import java.util.List;

/**
 * 定义接口方法
 */
public interface StudentService {

    void deleteData();

    String insert(Integer count);

    List<String> treatByT();

    List<String> treatByS();

    List<String> treatS();

    List<String> treatT();

    List<String> lacture();
}
