package com.example.oasis.utils;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;



/**
 * Created with IntelliJ IDEA
 * User: Chen Hongyu
 * Date: 2020/7/28
 * Description: No Description
 */
public class GenerateDirUtil {

    public static enum Type {
        DEFAULT,
        FILETYPE
    }

    public static String fileDirectory(File file, Type type) {
        if (Type.FILETYPE.equals(type)) {
            String resDir = "/";
            resDir = new MimetypesFileTypeMap().getContentType(file);
            resDir.replace('\\', '/');
            return "/" + resDir;
        } else {
            String resDir = "/";
            resDir = file.getParent();
            return resDir;
        }

    }
}
