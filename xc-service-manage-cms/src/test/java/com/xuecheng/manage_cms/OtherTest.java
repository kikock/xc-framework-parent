package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.framework.utils.JsonUtils;
import com.xuecheng.manage_cms.service.SysDicthinaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @project_name: xc-framework-parent
 * @description: 不想每个都写 临时测试都在这
 * @create_name: kikock
 * @create_date: 2021-02-19 11:20
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class OtherTest {

    @Autowired
    SysDicthinaryService service;

    @Test
    public void test1() {
        SysDictionary byType = service.getByType("100");
        System.out.println(JsonUtils.toJson(byType));
    }
}
