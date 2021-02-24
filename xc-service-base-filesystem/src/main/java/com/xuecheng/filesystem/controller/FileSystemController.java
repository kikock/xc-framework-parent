package com.xuecheng.filesystem.controller;

import com.xuecheng.api.filesystem.FileSystemControllerApi;
import com.xuecheng.filesystem.service.FileSystemService;
import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @project_name: xc-service-base-filesystem
 * @description: 文件服务器显示层
 * @create_name: kikock
 * @create_date: 2021-02-24 14:47
 **/
@RestController
@RequestMapping("/filesystem")
public class FileSystemController implements FileSystemControllerApi {

    @Autowired
    FileSystemService fileSystemService;

    @Override
    @PostMapping("/upload")
    public UploadFileResult upload(@RequestParam("file") MultipartFile file,
                                   @RequestParam(value = "filetag", required = true) String
                                           filetag,
                                   @RequestParam(value = "businesskey", required = false) String
                                           businesskey,
                                   @RequestParam(value = "metedata", required = false) String
                                           metadata) {
        return fileSystemService.upload(file, filetag, businesskey, metadata);
    }
}
