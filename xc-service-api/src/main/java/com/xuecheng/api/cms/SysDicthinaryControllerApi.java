package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.system.SysDictionary;
import io.swagger.annotations.ApiOperation;

/**
 * @project_name: xc-service-api
 * @description: 数据字典接口
 * @create_name: kikock
 * @create_date: 2021-02-19 11:02
 **/
public interface SysDicthinaryControllerApi {

    //数据字典
    @ApiOperation(value = "数据字典查询接口")
    public SysDictionary getByType(String type);
}
