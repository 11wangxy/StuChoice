package com.demo.service;

import java.util.List;

public interface StudentService {

    void deleteData();

    String insert(Integer count);

    List<String> treatByT();

    List<String> treatByS();

    List<String> treatS();

    List<String> treatT();

    List<String> lacture();
}
