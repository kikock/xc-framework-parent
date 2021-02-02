package com.xuecheng.manage_cms_client.mq;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.utils.JsonUtils;
import com.xuecheng.manage_cms_client.dao.CmsPageRepository;
import com.xuecheng.manage_cms_client.pageService.PageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @project_name: xc-service-manage-cms-client
 * @description: 监听消息队列(接收页面发布的消息)
 * @create_name: kikock
 * @create_date: 2021-02-01 14:59
 *
 **/
@Component
public class ConsumerPostPage{

    private static  final Logger log = LoggerFactory.getLogger(ConsumerPostPage.class);


    @Autowired
    PageService pageService;
    // 监听队列
    @RabbitListener(queues = ("${xuecheng.mq.queue}"))
    public  void postPage(String msg){
        log.info("解析消息开始");
        // 解析消息转换成map
        Map map = JsonUtils.fromJson(msg, Map.class);
        // 获取消息页面id
        String pageId = (String) map.get("pageId");
        //页面校验,查询页面是否存在
        CmsPage cmsPage = pageService.findCmsPageById(pageId);
        if(Objects.isNull(cmsPage)){
            log.error("receive cms post page,cmsPage is null:{}",msg.toString());
            return ;
        }
        //调用service方法 下载静态页面
        pageService.savePageToServerPath(pageId);
    }
}
