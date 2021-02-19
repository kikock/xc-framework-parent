package com.xuecheng.manage_course.controller;


import com.xuecheng.api.course.CategoryControllerApi;
import com.xuecheng.framework.domain.course.Category;
import com.xuecheng.manage_course.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @project_name: xc-service-manage-course
 * @description: 课程分类显示层
 * @create_name: kikock
 * @create_date: 2021/2/19 10:27
 **/
@RestController
@RequestMapping("/category")
public class CategoryController implements CategoryControllerApi {

    @Autowired
    CategoryService categoryService;

    @Override
    @GetMapping("/findTreeList/{isShow}")
    public List<Category> findTreeList(@PathVariable("isShow") String isShow) {
        return categoryService.findTreeList(isShow);
    }


}
