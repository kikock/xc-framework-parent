package com.xuecheng.manage_cms_client.dao;


import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @project_name: xc-service-manage-cms-client
 * @description: 页面dao
 * @create_name: kikock
 * @create_date: 2021/2/1 11:09
 */

public interface CmsPageRepository extends MongoRepository<CmsPage, String> {

    //根据页面名称查询
    CmsPage findByPageName(String pageName);

    //根据页面名称、站点Id、页面webpath查询
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName, String siteId, String pageWebPath);

}
