package com.example.oasis.utils;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA
 * User: Chen Hongyu
 * Date: 2020/7/27
 * Description: No Description
 */
public class FtpBean {
    /**
     * @类名 FtpBean
     * @创建人 Chen Hongyu
     * @描述
     */
    private String address;

    private String port;

    private String username;

    private String password;

    private String fileName;

    private String basepath;

    private InputStream inputStream;

    public String getAddress() {
        return address == null ? "116.62.26.185" : address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port == null ? "21" : port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username == null ? "user" : username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password == null ? "userpwd" : password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFileName() {
        return fileName == null ? "未命名" : fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBasepath() {
        return basepath == null ? "/" : basepath;
    }

    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }


}
