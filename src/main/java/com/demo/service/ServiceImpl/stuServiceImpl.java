package com.demo.service.ServiceImpl;

import com.demo.entity.studentDTO;
import com.demo.mapper.StudentMapper;
import com.demo.service.StudentService;
import com.demo.utils.stuChoice;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.demo.utils.StudentPatterns.*;


@Service
@Slf4j

public class stuServiceImpl implements StudentService {
    private static final String HAVE = "\n共有";
    private static final String STUDENT = "位学生";
    private static final String LISTEN = "听课";
    private static final String BLANK = "  ";
    @Resource
    private stuChoice stuChoice;
    @Resource
    private StudentMapper studentMapper;

    @Override
    public void deleteData() {
        studentMapper.deleteTable();
    }

    @Override
    public void insert(Integer count) {
        long startTime = System.nanoTime();    // 记录开始时间
        ExecutorService executorService = Executors.newFixedThreadPool(20); // 创建固定大小的线程池
        for (int i = 0; i < count; i++) {
            final int index = i;
            executorService.execute(() -> {
                double random = Math.random();
                studentDTO dto = new studentDTO();
                if (random < 0.45) {
                    BeanUtils.copyProperties(stuChoice.newBadStudent(), dto);
                    studentMapper.insertStudent(dto);
                } else {
                    BeanUtils.copyProperties(stuChoice.newGoodStudent(), dto);
                    studentMapper.insertStudent(dto);
                }
                if (index % 500 == 0) {
                    log.info("插入第{}条数据成功", index);
                }
                long endTime = System.nanoTime();      // 记录结束时间
                long duration = endTime - startTime;   // 计算程序执行时间，单位为纳秒
                double durationInMs = duration / 1e6;  // 将纳秒转换为毫秒
                System.out.println("程序执行时间：" + durationInMs + " 毫秒");
            });
        }
        executorService.shutdown(); // 关闭线程池
        while (!executorService.isTerminated()) {
            // 等待所有任务执行完毕
        }
        log.info("插入数据成功");
    }

    public List<String> collect(List<studentDTO> list) {
        return list.stream().map(student -> student.getNumber() + BLANK + student.getName() + BLANK + student.getStatus() + BLANK
                + student.getAction1() + BLANK + student.getAction2()).collect(Collectors.toList());
    }

    @Override
    public List<String> treatByS() {
        List<String> collect = collect(studentMapper.selectA1(TREAT_BY_STUDENT));
        collect.add(0, HAVE + studentMapper.count1(TREAT_BY_STUDENT) + STUDENT + TREAT_BY_STUDENT);
        return collect;
    }

    @Override
    public List<String> treatByT() {
        List<String> collect = collect(studentMapper.selectA2(TREAT_BY_TEACHER));
        collect.add(0, HAVE + studentMapper.count2(TREAT_BY_TEACHER) + STUDENT + TREAT_BY_TEACHER);
        return collect;
    }

    @Override
    public List<String> treatS() {
        List<String> collect = collect(studentMapper.selectA1(TREAT_STUDENT));
        collect.add(0, HAVE + studentMapper.count1(TREAT_STUDENT) + STUDENT + TREAT_STUDENT);
        return collect;
    }

    @Override
    public List<String> treatT() {
        List<String> collect = collect(studentMapper.selectA2(TREAT_TEACHER));
        collect.add(0, HAVE + studentMapper.count2(TREAT_TEACHER) + STUDENT + TREAT_TEACHER);
        return collect;
    }

    @Override
    public List<String> lacture() {
        List<String> collect = collect(studentMapper.selectS(LISTEN));
        collect.add(0, HAVE + studentMapper.countStatus(LISTEN) + STUDENT + LISTEN);
        return collect;
    }
}

