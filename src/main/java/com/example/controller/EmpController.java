package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize, String name,Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
                       ){
        log.info("员工分页显示参数为：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }
    //实现批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("员工批量删除功能,id为:{}",ids);

        //调用service进行处理
        empService.delete(ids);
        return Result.success();
    }

    //新增员工功能
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("员工新增功能，参数为:{}",emp);

        empService.save(emp);
        return Result.success();
    }
    //编辑员工，查询id
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("编辑id查询信息操作");
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }
    //编辑员工信息
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("员工修改功能:{}",emp);
        empService.update(emp);
        return Result.success();
    }

}
