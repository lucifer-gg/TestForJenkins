package com.example.oasis.controller.update;


import com.example.oasis.blImpl.update.UpdateServiceImpl;
import com.example.oasis.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
public class UpdateController {
    @Autowired
    UpdateServiceImpl updateService;

    /**
     *@描述 根据csv文件的名称，更新数据库
     *@参数  [filename]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @GetMapping("/update/{filename}")
    public ResponseVO upload(@PathVariable String filename){
        return updateService.update(filename);
    }


    /**
     *@描述 上传csv文件
     *@参数  [multipartFile]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseVO upload(@RequestParam("file") MultipartFile multipartFile) {
        File file = transferToFile(multipartFile);
        String originalFilename = multipartFile.getOriginalFilename();
        return updateService.upload(file, originalFilename);

    }

    /**
     *@描述 类型转化
     *@参数  [multipartFile]
     *@返回值  java.io.File
     *@创建人  Chen Hongyu
     */
    private File transferToFile(MultipartFile multipartFile) {
//        选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
        File file = null;
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            String[] filename = originalFilename.split("\\.");
            file = File.createTempFile(filename[0], filename[1]);
            multipartFile.transferTo(file);
            file.deleteOnExit();
            System.out.println(file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }



}

