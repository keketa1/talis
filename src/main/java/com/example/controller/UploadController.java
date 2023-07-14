package com.example.controller;

import com.example.pojo.Result;
import com.example.utlis.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String url = aliOSSUtils.upload(image);
        return Result.success(url);
    }
//
//    @PostMapping("/upload")
//    public Result upload(String username , Integer age , MultipartFile image) throws IOException {
//        log.info("文件上传功能，参数为:{},{},{}",username,age,image);
//        //获取文件名称
//        String filename = image.getOriginalFilename();
//        System.out.println("文件名称为："+filename);
//
//        //修改文件名称为字符串不重复
//        int index = filename.lastIndexOf(".");
//        String substring = filename.substring(index);
//
//        String newFileName = UUID.randomUUID().toString() + substring;
//
//        //文件保存到本地磁盘
//        String url = "Z:/img/"+newFileName;
//        image.transferTo(new File(url));
//        return Result.success(url);
//    }
}
