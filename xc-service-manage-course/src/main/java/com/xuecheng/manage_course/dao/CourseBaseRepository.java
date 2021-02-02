package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CourseBase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @project_name: xc-service-manage-course
 * @description: 课程管理基础dao
 * @create_name: kikock
 * @create_date: 2021/2/2 16:08
 *
 **/
public interface CourseBaseRepository extends JpaRepository<CourseBase,String> {
}
