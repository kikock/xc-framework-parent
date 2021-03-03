package com.xuecheng.manage_course;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_course.client.CmsPageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @project_name: xc-framework-parent
 * @description: eureka测试
 * @create_name: kikock
 * @create_date: 2021-02-26 16:23
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class eurekaTest {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CmsPageClient cmsPageClient;

    //负载均衡调用
    @Test
    public void testRibbon() {
        //确定要获取的服务名
        String serviceId = "XC-SERVICE-MANAGE-CMS";
        for (int i = 0; i < 10; i++) {
            //ribbon客户端从eurekaServer中获取服务列表,根据服务名获取服务列表
            ResponseEntity<CmsPage> forEntity = restTemplate.getForEntity("http://" + serviceId
                    + "/cms/page/get/5a754adf6abb500ad05688d9", CmsPage.class);
            CmsPage cmsPage = forEntity.getBody();
            System.out.println(cmsPage);
        }
    }


    @Test
    public void testFeign() {
        //通过服务id调用cms的查询页面接口
        CmsPage cmsPage = cmsPageClient.findCmsPageById("5a754adf6abb500ad05688d9");
        System.out.println(cmsPage);
    }
}
