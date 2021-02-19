package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @project_name: xc-service-manage-cms
 * @description: cms配置管理Dao层
 * @create_name: kikock
 * @create_date: 2021-01-19 11:23
 **/
public interface CmsConfigRepository extends MongoRepository<CmsConfig, String> {

    //根据模板名称查询
    CmsConfig findByName(String name);

}
