/**
 * Project Name : miracle-camel-demo
 * File Name    : Traditional
 * Package Name : com.miracle.demo.helloworld
 * Date         : 2019-11-18 19:16
 * Author       : fan.wenbin
 * Copyright (c) 2018, fan.wenbin@ustcinfo.com All Rights Reserved.
 */
package com.miracle.demo.helloworld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @program: miracle-camel-demo
 * @className: Traditional
 * @description: TODO
 * @CreateTime: 2019-11-18 19:16
 * @author: fan.wenbin
 * @version: V1.0
 */
public class Traditional {
    private static final String FROM_PATH = "/Users/awen/Desktop/from";
    private static final String TO_PATH = "/Users/awen/Desktop/to";

    public static void main(String[] args) throws Exception {

        File fromDir = new File(FROM_PATH);
        File toFileTemp = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        String fileNameTemp = null;
        int readCountTemp = -1;
        while (true) {

            for(File fileTemp : fromDir.listFiles()) {
                // 列出当前目录下所有文件，并逐个处理。

                fileNameTemp = fileTemp.getName();
                toFileTemp = new File(TO_PATH + File.separator + fileNameTemp);
                if(!toFileTemp.exists()) {
                    toFileTemp.createNewFile();
                }
                fileOutputStream = new FileOutputStream(toFileTemp);
                fileInputStream = new FileInputStream(fileTemp);
                byte[] byteTemp = new byte[100];
                // 读写源文件内容，并写入新文件
                while ((readCountTemp = fileInputStream.read(byteTemp)) != -1) {
                    fileOutputStream.write(byteTemp, 0, readCountTemp);
                }
                // 删除源文件
                fileTemp.delete();

                // 关闭相关的数据流，并将临时变量置空。
                fileInputStream.close();
                fileOutputStream.close();
                fileInputStream = null;
                fileOutputStream = null;
                toFileTemp = null;
                fileNameTemp = null;
                readCountTemp = -1;
            }
            // 3秒钟进行一次扫描
            Thread.sleep(3000);
        }
    }
}
