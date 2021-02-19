package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @project_name: xc-service-manage-cms
 * @description: 数据字典dao层
 * @create_name: kikock
 * @create_date: 2021-02-19 11:12
 **/
public interface SysDicthinaryRepository extends MongoRepository<SysDictionary, String> {

    //根据type查询字典
    SysDictionary findByDType(String type);
}
