package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsSiteControllerApi;
import com.xuecheng.framework.domain.cms.request.QuerySiteRequest;
import com.xuecheng.framework.domain.cms.response.CmsSiteResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project_name: xc-framework-parent
 * @description: 站点管理显示层
 * @create_name: kikock
 * @create_date: 2021-02-07 14:46
 **/
@RestController
@RequestMapping("/cms/site")
public class CmsSiteController implements CmsSiteControllerApi {

    @Autowired
    SiteService siteService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size,
                                        QuerySiteRequest queryPageRequest) {
        return siteService.findList(page, size, queryPageRequest);
    }

    @Override
    @PostMapping("/add")
    public CmsSiteResult add(@RequestBody QuerySiteRequest querySiteRequest) {
        return siteService.add(querySiteRequest);
    }

    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult del(@PathVariable("id") String id) {
        return siteService.del(id);
    }

}
