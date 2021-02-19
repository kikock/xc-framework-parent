package com.xuecheng.manage_course.dao;


import com.xuecheng.framework.domain.course.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @project_name: xc-service-manage-course
 * @description: 课程返利 jpa处理数据库
 * @create_name: kikock
 * @create_date: 2021/2/19 10:34
 **/
public interface CategoryRepository extends JpaRepository<Category, String> {

    //查询是否显示课程类型 1显示 0不显示
    List<Category> findByIsshow(String isShow);

}
