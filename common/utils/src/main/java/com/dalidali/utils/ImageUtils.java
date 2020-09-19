package com.dalidali.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: manga
 * @description: 操作图片工具类
 * @author: qinda
 * @create: 2020-08-27 21:36
 **/
public class ImageUtils {

    /**
     * 根据路径获取图片
     * @param path  绝对路径
     * @return 返回byte数组
     */
    public static byte[] getImage(String path) {
        File file = new File(path);
        FileInputStream inputStream = null;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(file);
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) { }
        }
        return bytes;
    }

    /**
     * 返回图片
     * @param root 路径前缀
     * @param path 具体路径
     * @return 返回byte数组
     */
    public static byte[] getImage(String root,String path) {
        return getImage(root+"/"+path);
    }
}
