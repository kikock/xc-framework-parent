package com.xuecheng.manage_cms_client;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.manage_cms_client.dao.CmsPageRepository;
import com.xuecheng.manage_cms_client.dao.CmsSiteRepository;
import com.xuecheng.manage_cms_client.pageService.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

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
    CmsPageRepository cmsPageRepository;

    @Autowired
    PageService service;


    @Test
    public void findById() {
        //查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("600a6cda58e4a45afc17b370");
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            System.out.println(cmsPage.toString());
        }else {
            System.out.println("未找到数据!");
        }
        //查询 站点
        Optional<CmsSite> cmsSite = cmsSiteRepository.findById("6017be4fd21800001d007e32");
        if (cmsSite.isPresent()) {
            CmsSite cmsSite1 = cmsSite.get();
            System.out.println(cmsSite1.toString());
        }else {
            System.out.println("未找到数据!");
        }

    }

}
