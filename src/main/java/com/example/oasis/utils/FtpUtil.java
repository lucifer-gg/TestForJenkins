package com.example.oasis.utils;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA
 * User: Chen Hongyu
 * Date: 2020/7/27
 * Description: No Description
 */
public class FtpUtil {

    public static boolean uploadFile(FtpBean ftpBean) {

        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(ftpBean.getAddress(), Integer.valueOf(ftpBean.getPort()));
            ftp.login(ftpBean.getUsername(), ftpBean.getPassword());
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.out.println("disconnect");
                return result;
            }

            String temPath = ftpBean.getBasepath();
            String fileName = ftpBean.getFileName();
            if (!ftp.changeWorkingDirectory(temPath)) {
                String[] tempPathList = temPath.split("/");
                for (String dir : tempPathList) {
                    if (dir != null && dir != "") {
                        if (!ftp.makeDirectory(dir)) {
                            System.out.println("can't make dir");
                            return result;
                        } else {
                            ftp.changeWorkingDirectory(dir);
                        }
                    }
                }
            }

            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();
            ftp.setControlEncoding("UTF-8");
//            ftp.enterLocalActiveMode();
            System.out.println("start upload");
            result = ftp.storeFile(fileName, ftpBean.getInputStream());
            ftpBean.getInputStream().close();
            ftp.logout();
            if (!result) {
                return result;
            }
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static InputStream readFile(FtpBean ftpBean) {
        InputStream in = null;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(ftpBean.getAddress(), Integer.valueOf(ftpBean.getPort()));
            ftp.login(ftpBean.getUsername(), ftpBean.getPassword());
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.out.println("disconnect");
                return in;
            }
            ftp.changeWorkingDirectory(ftpBean.getBasepath());
            ftp.enterLocalPassiveMode();
            ftp.setControlEncoding("UTF-8");
            System.out.println("start read");
            in = ftp.retrieveFileStream(ftpBean.getFileName());
            System.out.println("finish read");
            return in;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return in;
    }


}
