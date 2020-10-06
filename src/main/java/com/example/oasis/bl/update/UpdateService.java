package com.example.oasis.bl.update;

import com.example.oasis.vo.ResponseVO;

import java.io.File;

public interface UpdateService {
    /**
     *@描述 上传csv文件
     *@参数  [file, filename]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO upload(File file,String filename);
    /**
     *@描述 更新csv文件
     *@参数  [filename]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO update(String filename);

//    public String addCSV(String filepath);
}
