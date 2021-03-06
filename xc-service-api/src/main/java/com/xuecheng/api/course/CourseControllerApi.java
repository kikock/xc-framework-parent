package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @project_name: xc-service-api
 * @description: 课程管理接口
 * @create_name: kikock
 * @create_date: 2021-02-02 16:06
 **/
@Api(value = "课程管理接口", description = "课程管理接口，提供课程的增、删、改、查")
public interface CourseControllerApi {

    @ApiOperation("课程计划查询树形结构")
    public List<Teachplan> findTeachplanList(String courseId);

    @ApiOperation("添加课程计划")
    public ResponseResult addTeachplan(Teachplan teachplan);

    @ApiOperation("查询我的课程列表")
    public QueryResponseResult findCourseList(int page, int size, CourseListRequest courseListRequest);

    @ApiOperation("查询课程信息")
    public QueryResponseResult findByCoursebaseId(String id);

    @ApiOperation("查询课程图片")
    public CoursePic coursepicList(String id);

    @ApiOperation("添加课程图片")
    public ResponseResult addCoursePic(String courseId, String pic);

    @ApiOperation("删除课程图片")
    public ResponseResult deleteCoursePic(String courseId);
}
