package com.xuecheng.manage_course;

import com.xuecheng.framework.domain.course.Category;
import com.xuecheng.framework.utils.JsonUtils;
import com.xuecheng.manage_course.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @project_name: xc-framework-parent
 * @description: 课程计划测试类
 * @create_name: kikock
 * @create_date: 2021-02-04 09:16
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceTest {
    @Autowired
    CategoryService categoryService;


    // 查询课程计划树形结构
    @Test
    public void findTeachplanList() {
        List<Category> result = categoryService.findTreeList("1");
        System.out.println(JsonUtils.toJson(result));
    }


}
