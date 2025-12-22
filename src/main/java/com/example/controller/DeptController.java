package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
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
        //System.out.println("depts = " + depts);
        log.info("depts = " + depts);
        return Result.success(depts);
    }

    /**
     * 查询部门
     * @param id = 部门id
     * @return 返回部门信息
     */
    @RequestMapping(value = "/depts/{id}",method = RequestMethod.GET)
    public Result get(@PathVariable("id") Integer id){
        Dept dept = deptService.getById(id);
        log.info("dept = " + dept);
        return Result.success(dept);
    }

    /**
     * 删除部门
     * @param id = 部门id
     * @return 不返回数据
     */
    @RequestMapping(value = "/depts",method = RequestMethod.DELETE)
    public Result delete(@RequestParam("id") Integer id){
        deptService.delete(id);
        //System.out.println("删除成功");
        log.debug("删除成功");
        return Result.success();
    }

    /**
     * 添加部门
      * @param dept = 部门信息
     * @return 不返回数据
     */
    @RequestMapping(value = "/depts",method = RequestMethod.POST)
    public Result insert (@RequestBody Dept dept) {
        deptService.insert(dept);
        //System.out.println("添加成功");
        log.debug("添加成功");
        return Result.success();
    }

    /**
     * 修改部门
     * @param dept = id+部门信息
     * @return 不返回数据
     */
    @RequestMapping(value = "/depts",method = RequestMethod.PUT)
    public Result update (@RequestBody Dept dept) {
        deptService.update(dept);
        //System.out.println("修改成功");
        log.debug("修改成功");
        return Result.success();
    }
}
