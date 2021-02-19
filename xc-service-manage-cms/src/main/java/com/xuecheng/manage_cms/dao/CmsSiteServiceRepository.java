package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsSiteServer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @project_name: xc-service-manage-cms
 * @description: 站点服务器Dao层
 * @create_name: kikock
 * @create_date: 2021-02-08 10:39
 **/
public interface CmsSiteServiceRepository extends MongoRepository<CmsSiteServer, String> {

    //根据站点服务器名称查询
    CmsSiteServer findByServerName(String serverName);

    //根据站点id查询服务器(多服务器处理 目前站点页面未修改为多服务器页面 后面添加)
    List<CmsSiteServer> findBySiteId(String id);

}
