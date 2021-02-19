package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @project_name: xc-service-manage-cms
 * @description: 站点管理Dao层
 * @create_name: kikock
 * @create_date: 2021-02-07 14:34
 **/
public interface CmsSiteRepository extends MongoRepository<CmsSite, String> {

    //根据站点名称查询
    CmsSite findBySiteName(String siteName);
}
