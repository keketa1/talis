package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//
//        //查询总记录数
//       Long count = empMapper.count();
//
//       //查询分页数据进行封装
//        Integer start = (page -1)* pageSize;
//        List<Emp> emps = empMapper.page(start, pageSize);
//
//
//        //创建PageBean进行封装
//        PageBean pageBean = new PageBean(count,emps);
//
//        return pageBean;
//    }


    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender,
                         LocalDate begin, LocalDate end ) {
        PageHelper.startPage(page,pageSize);

        List<Emp> empList = empMapper.list(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) empList;

        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
       return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {


        empMapper.deleteIds(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setPassword("123456");
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);
    }

    @Override
    public Emp findById(Integer id) {
        Emp emp = empMapper.findById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}
