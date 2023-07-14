package com.example.mapper;

import com.example.pojo.Dept;
import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {


//    @Select("select count(*) from emp")
//    Long count();
//
//    @Select("select * from emp limit #{start},#{pageSize}")
//    List<Emp> page(Integer start , Integer pageSize);
//
//    @Select("select * from emp")
      List<Emp> list(@Param("name") String name, @Param("gender")Short gender,
                     @Param("begin") LocalDate begin, @Param("end") LocalDate end);

      void deleteIds(@Param("ids") List<Integer> ids);

      void save(Emp emp);


      @Select("select * from emp where id=#{id}")
      Emp findById(Integer id);


      void update(Emp emp);
}
