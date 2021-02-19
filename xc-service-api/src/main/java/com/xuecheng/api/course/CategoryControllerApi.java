package com.xuecheng.api.course;


import com.xuecheng.framework.domain.course.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @project_name: xc-service-api
 * @description: 课程分类管理
 * @create_name: kikock
 * @create_date: 2021/2/19 10:24
 **/
@Api(value = "课程分类管理", description = "课程分类管理", tags = {"课程分类管理"})
public interface CategoryControllerApi {

    @ApiOperation("查询分类(树形结构)")
    public List<Category> findTreeList(String isShow);

}
