package com.demo.mapper;

import com.demo.entity.studentDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Delete("delete from test01.student")
    void deleteTable();

    void insertStudent(@Param("list") List<studentDTO> studentsDto);

    @Select("select * from test01.student where action1 = #{action1}")
    List<studentDTO> selectA1(String action1);

    @Select("select * from test01.student where action0 = #{action2}")
    List<studentDTO> selectA2(String action2);

    @Select("select * from test01.student where status = #{status} ")
    List<studentDTO> selectS(String status);

    @Select("select count(*) from test01.student where action1 = #{action1}")
    Integer count1(String action1);

    @Select("select count(*) from test01.student where action2 = #{action2}")
    Integer count2(String action2);

    @Select("select count(*) from test01.student where status = #{status}")
    Integer countStatus(String status);
}
