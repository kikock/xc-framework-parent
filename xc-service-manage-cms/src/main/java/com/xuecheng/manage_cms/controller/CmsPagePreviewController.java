package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPagePreviewControllerApi;
import com.xuecheng.framework.web.BaseController;
import com.xuecheng.manage_cms.service.PageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @project_name: xc-framework-parent
 * @description: 页面预览显示层
 * @create_name: kikock
 * @create_date: 2021-01-22 14:41
 **/
@Controller
@RequestMapping("/cms/preview")
public class CmsPagePreviewController extends BaseController implements CmsPagePreviewControllerApi {

    @Autowired
    PageService pageService;

    //接收到页面id
    @RequestMapping(value = "/{pageId}", method = RequestMethod.GET)
    public void preview(@PathVariable("pageId") String pageId) {
        String pageHtml = pageService.getPageHtml(pageId);
        if (StringUtils.isNotEmpty(pageHtml)) {
            try {
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(pageHtml.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
