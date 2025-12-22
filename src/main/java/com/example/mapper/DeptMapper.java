package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    List<Dept> findAll();

    void delete(Integer id);

    void insert(Dept dept);

    void update(Dept dept);

    Dept findById(Integer id);
}
