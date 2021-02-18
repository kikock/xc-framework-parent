package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @project_name: xc-framework-parent
 * @description: 页面模板dao
 * @create_name: kikock
 * @create_date: 2021-01-19 17:31
 **/
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate, String> {
}
