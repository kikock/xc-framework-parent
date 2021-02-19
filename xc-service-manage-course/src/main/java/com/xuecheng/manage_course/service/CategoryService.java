package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.Category;
import com.xuecheng.manage_course.dao.CategoryMapper;
import com.xuecheng.manage_course.dao.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @project_name: xc-service-manage-course
 * @description: 课程类型管理服务层
 * @create_name: kikock
 * @create_date: 2021/2/19 10:40
 **/
@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryRepository categoryRepository;

    /**
     * @description: 查询课程类型树形结构
     * @param: 是否显示课程类型
     * @return: 课程类型树形list
     * @create_name: kikock
     * @create_date: 2021/2/4 9:44
     **/
    public List<Category> findTreeList(String isShow) {
        List<Category> byIsshow = categoryRepository.findByIsshow(isShow);
        return formatterList(byIsshow);
    }

    /**
     * @description: 树形转换
     * @param: 所有课程list
     * @return: 转换后树形结构
     * @create_name: kikock
     * @create_date: 2021/2/4 9:59
     **/
    private List<Category> formatterList(List<Category> list) {
        //返回数据
        List<Category> result = new ArrayList<>();
        Map<String, Category> cache = new HashMap<>();
        //课程id 放进cache
        for (Category category : list) {
            //遍历所有的菜单放进map缓存 <id object>
            cache.put(category.getId(), category);
        }
        for (Category category : list) {
            //判断1级菜单
            if ("0".equals(category.getParentid())) {
                //一级菜单
                result.add(category);
            } else {
                String pid = category.getParentid();
                Category parent = cache.get(pid);
                if (parent != null) {
                    List<Category> children = parent.getChildren();
                    if (children == null) {
                        children = new ArrayList<>();
                        parent.setChildren(children);
                    }
                    children.add(category);
                }
            }
        }
        return result;
    }


}
