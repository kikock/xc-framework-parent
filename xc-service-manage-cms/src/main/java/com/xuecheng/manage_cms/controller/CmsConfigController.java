package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsConfigControllerApi;
import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.domain.cms.CmsConfigModel;
import com.xuecheng.framework.domain.cms.request.QueryCmsConfigRequest;
import com.xuecheng.framework.domain.cms.response.CmsConfigResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.CmsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project_name: xc-service-manage-cms
 * @description: cms配置管理显示层
 * @create_name: kikock
 * @create_date: 2021-01-19 11:25
 **/

@RestController
@RequestMapping("/cms/config")
public class CmsConfigController implements CmsConfigControllerApi {

    @Autowired
    CmsConfigService service;


    @Override
    @GetMapping("/getmodel/{id}")
    public CmsConfig getmodel(@PathVariable("id") String id) {
        return service.getConfigById(id);
    }

    @Override
    @PostMapping("/add")
    public CmsConfigResult add(@RequestBody CmsConfig cmsConfig) {
        return service.add(cmsConfig);
    }

    @Override
    @PostMapping("/addModel/{id}")
    public CmsConfigResult addModel(@PathVariable("id") String id, @RequestBody CmsConfigModel configModel) {
        return service.addModel(id, configModel);
    }

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size,
                                        QueryCmsConfigRequest queryCmsConfigRequest) {
        return service.findList(page, size, queryCmsConfigRequest);
    }

    @Override
    @PostMapping("/edit")
    public CmsConfigResult edit(CmsConfig cmsConfig) {
        return service.edit(cmsConfig);
    }

    @DeleteMapping("/del/{id}")
    public ResponseResult del(@PathVariable("id") String id) {
        return service.del(id);
    }

    @DeleteMapping("/delModel/{id}/{key}")
    public ResponseResult delModel(@PathVariable("id") String id, @PathVariable("key") String key) {
        return service.delModel(id, key);
    }
}
