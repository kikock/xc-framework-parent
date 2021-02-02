package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @project_name: xc-service-manage-course
 * @description:  课程计划dao
 * @create_name:  kikock
 * @create_date:  2021/2/2 16:10
 *
 **/
@Mapper
public interface TeachplanMapper {
    //课程计划查询
    public TeachplanNode selectList(String courseId);
}
