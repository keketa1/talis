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

    @GetMapping("/depts")
    public Result findAll(){
        log.info("部门查询操作");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("部门删除操作");
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result insert(@RequestBody Dept dept){
        log.info("部门添加操作");
        deptService.insert(dept);
        return Result.success();
    }
    @GetMapping("/depts/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("修改部门查询");
        Dept dept1 =  deptService.findById(id);
        return Result.success(dept1);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        log.info("修改部门操作");
        deptService.update(dept);
        return Result.success();
    }

}
