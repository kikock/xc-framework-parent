package com.xuecheng.manage_cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.utils.JsonUtils;
import com.xuecheng.manage_cms.controller.CmsSiteController;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import com.xuecheng.manage_cms.service.SiteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator
 * @version 1.0
 * @create kikock
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsSiteTest {

    @Autowired
    CmsSiteRepository cmsSiteRepository;

    @Autowired
    CmsSiteController cmsSiteController;

    @Autowired
    SiteService service;


    // Controller测试
    //分页查询页面 接口
    @Test
    public void findList() {
        //分页参数
        int page = 1;//从0开始
        int size = 10;
        QueryResponseResult result = cmsSiteController.findList(page, size, null);
        System.out.println(JsonUtils.toJson(result));
    }


}
