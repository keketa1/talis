package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void delete(int id);

    void insert(Dept dept);


    Dept findById(Integer id);

    void update(Dept dept);
}
