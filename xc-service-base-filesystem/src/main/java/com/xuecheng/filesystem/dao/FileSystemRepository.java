package com.xuecheng.filesystem.dao;

import com.xuecheng.framework.domain.filesystem.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @project_name: xc-service-base-filesystem
 * @description: 文件服务dao层
 * @create_name: kikock
 * @create_date: 2021-02-20 14:06
 **/
public interface FileSystemRepository extends MongoRepository<FileSystem, String> {
}
