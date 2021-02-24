package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CoursePic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project_name: xc-framework-parent
 * @description: 课程图片DAO
 * @create_name: kikock
 * @create_date: 2021-02-24 16:19
 **/
public interface CoursePicRepository extends JpaRepository<CoursePic, String> {

    //删除成功返回1否则返回0
    long deleteByCourseid(String courseid);

}
