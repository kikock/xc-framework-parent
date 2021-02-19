package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QuerySiteRequest;
import com.xuecheng.framework.domain.cms.response.CmsSiteResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @project_name: xc-service-api
 * @description: 站点管理接口
 * @create_name: kikock
 * @create_date: 2021-02-07 14:41
 **/
@Api(value = "站点管理页面管理接口", description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsSiteControllerApi {

    //页面查询
    @ApiOperation("分页查询站点列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
    })
    public QueryResponseResult findList(int page, int size, QuerySiteRequest queryPageRequest);

    //新增页面
    @ApiOperation("新增站点")
    public CmsSiteResult add(QuerySiteRequest querySiteRequest);


    //删除页面
    @ApiOperation("删除站点")
    public ResponseResult del(String id);

}
