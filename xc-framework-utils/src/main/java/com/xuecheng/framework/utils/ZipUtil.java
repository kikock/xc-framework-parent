package com.xuecheng.framework.utils;


import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * @project_name: xc-framework-utils
 * @description: Zip打包解包工具
 * @create_name: kikock
 * @create_date: 2021-01-21 16:23
 */
public class ZipUtil {

    /**
     * 解压zip文件（带密码）
     *
     * @param zipFilePath
     * @param targetPath
     * @param password
     * @throws ZipException
     */
    public static void unzip(String zipFilePath, String password, String targetPath) throws Exception {
        ZipFile zipFile = new ZipFile(zipFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(password);
        }
        zipFile.extractAll(targetPath);
    }

    public static void main(String[] args) throws Exception {
        ZipUtil.unzip("F:\\develop\\upload\\upload.zip", "F:\\develop\\upload\\zip\\");
    }

    /**
     * 解压zip文件
     *
     * @param zipFilePath
     * @param targetPath
     * @throws ZipException
     */
    public static void unzip(String zipFilePath, String targetPath) throws Exception {
        ZipFile zipFile = new ZipFile(zipFilePath);
        zipFile.extractAll(targetPath);
    }
}
