package com.xuecheng.manage_cms_client.dao;


import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 *
 * @project_name: xc-service-manage-cms-client
 * @description: 站点dao
 * @create_name: kikock
 * @create_date: 2021/2/1 11:09
 *
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {

}
