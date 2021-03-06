package com.xuecheng.api.cms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @project_name: xc-service-api
 * @description: 页面预览
 * @create_name: kikock
 * @create_date: 2021-02-01 10:25
 **/
@Api(value = "页面预览接口", description = "cms页面预览接口")
public interface CmsPagePreviewControllerApi {
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParam(name = "pageId", value = "页面id", required = true)
    public void preview(String pageId);
}
