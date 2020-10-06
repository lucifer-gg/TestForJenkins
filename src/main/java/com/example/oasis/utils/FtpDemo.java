package com.example.oasis.utils;

import java.io.*;


/**
 * Created with IntelliJ IDEA
 * User: Chen Hongyu
 * Date: 2020/7/28
 * Description: No Description
 */
public class FtpDemo {

    private static void uploadfile() {
        File file = new File("D:\\software.csv");
        if (file.isFile() && file.exists()) {
            //设置FTP上传的基本信息，可直接初始化数据
            FtpBean ftp = new FtpBean();
            ftp.setFileName(file.getName());
            try {
                //将文件转换成一个输入流
                InputStream in = new FileInputStream(file);
                ftp.setInputStream(in);
                //传入文件名称，和文件输入流，上传至FTP服务器
                boolean isOk = FtpUtil.uploadFile(ftp);
                if (isOk) {
                    System.out.println("文件上传成功");
                } else {
                    System.out.println("文件上传失败");
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在");
        }
    }

    private static void readFile() {
        InputStream in = null;
        BufferedReader reader = null;
        FtpBean ftp = new FtpBean();
        ftp.setFileName("software.csv");
        try {
            in = FtpUtil.readFile(ftp);
            if (in != null) {
                reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                while (reader.ready()) {
                    String line = reader.readLine();
                    System.out.println(line);
                }
            }
            else{
                System.out.println("文件读取失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        readFile();
    }

}
