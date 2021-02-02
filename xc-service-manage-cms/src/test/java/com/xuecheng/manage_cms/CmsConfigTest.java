package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.utils.JsonUtils;
import com.xuecheng.manage_cms.controller.CmsConfigController;
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
public class CmsConfigTest {

    @Autowired
    CmsConfigController configController;

    // Controller测试
    //      /cms/config/getmodel/{id}
    // 获取配置信息  轮播图
    @Test
    public void getConfigById() {
        CmsConfig cmsConfig = configController.getmodel("5a791725dd573c3574ee333f");
        String result = JsonUtils.toJson(cmsConfig);
        System.out.println(result);
    }

    //分页查询页面 接口
    @Test
    public void findList() {
        //分页参数
        int page = 1;//从0开始
        int size = 10;
        QueryResponseResult result = configController.findList(page, size, null);
        System.out.println(JsonUtils.toJson(result));
    }


}
