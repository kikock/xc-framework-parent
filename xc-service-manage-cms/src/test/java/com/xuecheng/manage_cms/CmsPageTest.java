package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.utils.JsonUtils;
import com.xuecheng.manage_cms.controller.CmsPageController;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 * @create kikock
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Autowired
    CmsPageController cmsPageController;

    @Autowired
    PageService service;


    // Controller测试
    //分页查询页面 接口
    @Test
    public void findList() {
        //分页参数
        int page = 1;//从0开始
        int size = 10;
        QueryResponseResult result = cmsPageController.findList(page, size, null);
        System.out.println(JsonUtils.toJson(result));
    }

    //页面   添加接口
    @Test
    public void addPageTest() {
        //查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("5ffd696f37ece3463c26e2c4");
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            cmsPage.setPageName("轮播图测试添加");
            cmsPage.setPageId(null);
            CmsPageResult result = cmsPageController.add(cmsPage);
            System.out.println(JsonUtils.toJson(result));
        } else {
            System.out.println("未找到数据!");
        }
    }

    //页面 按照id查询
    @Test
    public void findByIdTest() {
        CmsPage result = cmsPageController.findById("5ffd696f37ece3463c26e2c4");
        System.out.println(JsonUtils.toJson(result));
    }

    //页面 修改接口
    @Test
    public void editPageTest() {
        //查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("5ffd696f37ece3463c26e2c4");
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            //设置要修改值
            cmsPage.setPageAliase("editPageTest 修改页面");

            //修改
            CmsPageResult result = cmsPageController.edit(cmsPage.getPageId(), cmsPage);
            System.out.println(JsonUtils.toJson(result));
        } else {
            System.out.println("未找到数据!");
        }
    }

    //页面 按照id查询
    @Test
    public void deleteTest() {
        ResponseResult result = cmsPageController.del("600a47bf58e4a448c49dd75a");
        System.out.println(JsonUtils.toJson(result));
    }

    // service测试
    // 页面模板类型配置
    @Test
    public void getModelByPageIdTest() {
        Map result = service.getModelByPageId("600a6cda58e4a45afc17b370");
        System.out.println(JsonUtils.toJson(result));
    }

    // 获取数据模型文件的内容
    @Test
    public void getTemplateByPageIdTest() {
        String templateByPageId = service.getTemplateByPageId("600a6cda58e4a45afc17b370");
        System.out.println(templateByPageId);
    }

    //页面静态化
    @Test
    public void getPageHtmlTEst() {
        String pageHtml = service.getPageHtml("600a6cda58e4a45afc17b370");
        System.out.println(pageHtml);
    }

    @Test
    public void testFindAll() {
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);

    }


    //根据页面名称查询
    @Test
    public void testfindByPageName() {
        CmsPage cmsPage = cmsPageRepository.findByPageName("测试页面");
        System.out.println(cmsPage);
    }

    //条件分页查询
    @Test
    public void testFindAllExample() {
        int page = 1;
        int size = 10;
        Pageable pageable = new PageRequest(page, size);
        // 条件配置
        //条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        //页面别名模糊查询，需要自定义字符串的匹配器实现模糊查询
        //ExampleMatcher.GenericPropertyMatchers.contains() 包含
        //ExampleMatcher.GenericPropertyMatchers.startsWith()//开头匹配
        //页面名称模糊查询
        exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //查询条件
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageAliase("分类");
        // 条件对象实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        //条件构建完成 开始查询
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        System.out.println(all.getTotalPages());
    }


}
