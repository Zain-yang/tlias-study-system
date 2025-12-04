package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门
     * @return 返回所有部门信息
     */
    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    public Result list(){
        List<Dept> depts= deptService.findAll();
        System.out.println("depts = " + depts);
        return Result.success(depts);
    }

    /**
     * 删除部门
     * @param id = 部门id
     * @return 删除结果
     */
    @RequestMapping(value = "/depts",method = RequestMethod.DELETE)
    public Result delete(@RequestParam("id") Integer id){
        deptService.delete(id);
        System.out.println("删除成功");
        return Result.success();
    }

    /**
     * 添加部门
     * @param name = 部门名称
     * @return 添加结果
     */
    @RequestMapping(value = "/depts",method = RequestMethod.POST)
    public Result insert (@RequestParam("name") String name) {
        deptService.insert(name);
        System.out.println("插入成功");
        return Result.success();
    }
}
