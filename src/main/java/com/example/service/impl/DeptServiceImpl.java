package com.example.service.impl;

import com.example.mapper.DeptMapper;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll(); // Return the list of departments
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void insert(Dept dept) {
        dept.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        dept.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        deptMapper.insert(dept);
    }

    @Override
    public void update(Dept dept) {

        dept.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));

        deptMapper.update(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.findById(id);
    }
}
