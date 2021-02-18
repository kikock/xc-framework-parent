package com.xuecheng.manage_course.dao;


import com.xuecheng.framework.domain.course.CourseBase;
import org.apache.ibatis.annotations.Mapper;

/**
 * @project_name: xc-service-manage-course
 * @description: 课程管理mapper  mybatis处理数据库
 * @create_name: kikock
 * @create_date: 2021/2/2 16:08
 **/
@Mapper
public interface CourseMapper {
    CourseBase findCourseBaseById(String id);
}
