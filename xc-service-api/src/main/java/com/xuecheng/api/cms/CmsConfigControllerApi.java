package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.domain.cms.CmsConfigModel;
import com.xuecheng.framework.domain.cms.request.QueryCmsConfigRequest;
import com.xuecheng.framework.domain.cms.response.CmsConfigResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
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
@Api(value = "页面模板管理接口", description = "cms提供数据模型的管理、查询接口")
public interface CmsConfigControllerApi {

    @ApiOperation("根据id查询页面模板信息")
    CmsConfig getmodel(String id);

    //页面模板类型
    @ApiOperation("添加模板类型")
    CmsConfigResult add(CmsConfig cmsConfig);

    //模板内容
    @ApiOperation("添加模板信息")
    CmsConfigResult addModel(String id, CmsConfigModel configModel);


    //页面查询
    @ApiOperation("分页查询模板列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
    })
    QueryResponseResult findList(int page, int size, QueryCmsConfigRequest queryCmsConfigRequest);

    //更新页面
    @ApiOperation("页面模板更新")
    CmsConfigResult edit(CmsConfig cmsConfig);

    //删除页面
    @ApiOperation("删除模板类型")
    public ResponseResult del(String id);

    //删除页面
    @ApiOperation("删除模板消息")
    public ResponseResult delModel(String id, String key);
}
