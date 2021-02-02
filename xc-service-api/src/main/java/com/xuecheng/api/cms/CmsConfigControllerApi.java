package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.domain.cms.request.QueryCmsConfigRequest;
import com.xuecheng.framework.domain.cms.response.CmsConfigResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @project_name: xc-framework-parent
 * @description: cms配置管理接口
 * @create_name: kikock
 * @create_date: 2021-01-19 11:21
 **/
@Api(value = "cms配置管理接口", description = "cms提供数据模型的管理、查询接口")
public interface CmsConfigControllerApi {

    @ApiOperation("根据id查询CMS配置信息")
     CmsConfig getmodel(String id);

    //新增页面
    @ApiOperation("新增页面")
     CmsConfigResult add(CmsConfig cmsConfig);

    //页面查询
    @ApiOperation("分页查询模板列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
    })
     QueryResponseResult findList(int page, int size, QueryCmsConfigRequest queryCmsConfigRequest);


}
