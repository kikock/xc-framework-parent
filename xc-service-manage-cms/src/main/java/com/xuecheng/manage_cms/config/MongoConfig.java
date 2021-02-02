package com.xuecheng.manage_cms.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @project_name: xc-service-manage-cms
 * @description: mongodb 配置 注入Spring
 * @create_name: kikock
 * @create_date: 2021/2/1 11:09
 *
 */
@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.database}")
    String db;

    @Bean(value = "gridFSBucket")
    public GridFSBucket getGridFSBucket(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase(db);
        GridFSBucket bucket = GridFSBuckets.create(database);
        return bucket;
    }
}
