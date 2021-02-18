package com.xuecheng.manage_cms.dao;


import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @project_name: xc-framework-parent
 * @description: 页面信息dao层
 * @create_name: kikock
 * @create_date: 2021/2/1 15:43
 **/
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {
    //根据页面名称查询
    CmsPage findByPageName(String pageName);

    CmsPage findByPageNameAndPageWebPathAndSiteId(String pageName, String pageWebPath, String siteId);
}
