package com.xuecheng.manage_cms.service;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.utils.JsonUtils;
import com.xuecheng.manage_cms.config.RabbitmqConfig;
import com.xuecheng.manage_cms.dao.CmsConfigRepository;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.dao.CmsTemplateRepository;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @project_name: xc-framework-parent
 * @description: 页面管理服务层
 * @create_name: kikock
 * @create_date: 2021-01-19 17:31
 *
 **/
@Service
public class PageService {

    private static final Logger log = LoggerFactory.getLogger(PageService.class);

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Autowired
    CmsConfigRepository cmsConfigRepository;

    @Autowired
    CmsTemplateRepository cmsTemplateRepository;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Resource
    GridFSBucket gridFSBucket;
    @Resource
    RabbitTemplate rabbitTemplate;

    // @Autowired
    // GridFSBucket gridFSBucket;

    /**
     * 页面查询方法
     *
     * @param page             页码，从1开始记数
     * @param size             每页记录数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        if (Objects.isNull(queryPageRequest)) {
            queryPageRequest = new QueryPageRequest();
        }

        // 增加自定义条件
        //条件匹配器   页面名称模糊查询
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //查询条件 设置条件值
        CmsPage cmsPage = new CmsPage();
        // 页面名称
        if (StringUtils.isNotBlank(queryPageRequest.getPageAliase())) {
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
        // 模版id
        if (StringUtils.isNotBlank(queryPageRequest.getTemplateId())) {
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());
        }
        // 站点id
        if (StringUtils.isNotBlank(queryPageRequest.getSiteId())) {
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        // 页面id
        if (StringUtils.isNotBlank(queryPageRequest.getPageId())) {
            cmsPage.setPageId(queryPageRequest.getPageId());
        }
        // 页面文件名
        if (StringUtils.isNotBlank(queryPageRequest.getPageName())) {
            cmsPage.setPageName(queryPageRequest.getPageName());
        }
        // 条件对象实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        //条件构建完成 开始查询


        //分页参数
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 页面添加
     *
     * @param cmsPage 页面参数
     * @return
     */
    public CmsPageResult add(CmsPage cmsPage) {
        CmsPage cmsPage1 = cmsPageRepository.findByPageNameAndPageWebPathAndSiteId(cmsPage.getPageName(),
                cmsPage.getPageWebPath(),
                cmsPage.getSiteId());
        if (Objects.nonNull(cmsPage1)) {
            //已经存在此页面抛出异常
            ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        cmsPage.setPageId(null);
        cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS, cmsPage);
    }

    /**
     * 根据id 获取页面
     *
     * @param id 页面参数
     * @return
     */
    public CmsPage findById(String id) {
        Optional<CmsPage> optional = cmsPageRepository.findById(id);
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            return cmsPage;
        }
        return null;
    }

    /**
     * 页面修改
     *
     * @param id      页面id
     * @param cmsPage 页面参数
     * @return
     */
    public CmsPageResult edit(String id, CmsPage cmsPage) {
        CmsPage one = findById(id);
        if (Objects.nonNull(one)) {
            //更新模板id
            one.setTemplateId(cmsPage.getTemplateId());
            //更新所属站点
            one.setSiteId(cmsPage.getSiteId());
            //更新页面别名
            one.setPageAliase(cmsPage.getPageAliase());
            //更新页面名称
            one.setPageName(cmsPage.getPageName());
            //更新访问路径
            one.setPageWebPath(cmsPage.getPageWebPath());
            //更新物理路径
            one.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
            //更新url路径
            one.setDataUrl(cmsPage.getDataUrl());
            //执行更新
            CmsPage save = cmsPageRepository.save(one);
            if (save != null) {
                //返回成功
                CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.SUCCESS, save);
                return cmsPageResult;
            }
        }
        //返回失败
        return new CmsPageResult(CommonCode.FAIL, null);
    }

    /**
     * 删除页面
     *
     * @param id 页面id
     * @return
     */
    public ResponseResult del(String id) {
        Optional<CmsPage> optional = cmsPageRepository.findById(id);
        if (optional.isPresent()) {
            cmsPageRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);

    }



    /**
     * 根据id查询cms数据模型
     *
     * @param pageId 页面id
     * @return
     */
    public Map getModelByPageId(String pageId) {
        //取出页面的信息
        CmsPage cmsPage = this.findById(pageId);
        log.info("获取页面");
        if (cmsPage == null) {
            //页面不存在 24006
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
        }
        //取出页面的数据地址:dataUrl
        String dataUrl = cmsPage.getDataUrl();
        if (StringUtils.isEmpty(dataUrl)) {
            //页面dataUrl为空
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_DATAURLISNULL);
        }
        //通过restTemplate请求dataUrl获取数据
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
        log.info("请求页面 模板地址(dataUrl)");
        Map body = forEntity.getBody();
        return body;
    }


    /**
     * 获取页面的模板内容
     *
     * @param pageId 页面id
     * @return
     */
    public String getTemplateByPageId(String pageId) {
        //取出页面的信息
        CmsPage cmsPage = this.findById(pageId);
        log.info("获取页面");
        if (cmsPage == null) {
            //页面不存在
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
        }
        //获取页面的模板id
        String templateId = cmsPage.getTemplateId();
        if (StringUtils.isEmpty(templateId)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        //查询模板信息
        Optional<CmsTemplate> optional = cmsTemplateRepository.findById(templateId);
        log.info("获取页面模板");
        if (optional.isPresent()) {
            CmsTemplate cmsTemplate = optional.get();
            //获取模板文件id
            String templateFileId = cmsTemplate.getTemplateFileId();
            //从GridFS中取模板文件内容
            log.info("文件id:"+templateFileId);
            //根据文件id查询文件
            GridFSFile gridFSFile =
                    gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(templateFileId)));
            log.info("获取页面模板文件");
            //打开一个下载流对象
            GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
            //创建GridFsResource对象，获取流
            GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
            //从流中取数据
            try {
                String content = IOUtils.toString(gridFsResource.getInputStream());
                return content;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("未获取到页面模板");
        return null;
    }

    /**
     * 页面静态化
     *
     * @param pageId 页面id
     * @return
     */
    public String getPageHtml(String pageId) {
//获取页面模型数据
        Map model = this.getModelByPageId(pageId);
        log.info("获取页面模型数据");
        if (Objects.isNull(model)) {
//获取页面模型数据为空
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_DATAISNULL);
        }
        //获取页面模板
        log.info("获取页面模板");
        String templateContent = getTemplateByPageId(pageId);
        if (StringUtils.isEmpty(templateContent)) {
//页面模板为空
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        //执行静态化
        log.info("执行静态化");
        String html = generateHtml(templateContent, model);
        if (StringUtils.isEmpty(html)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_HTMLISNULL);
        }
        return html;
    }

      //执行页面静态
    public String generateHtml(String template, Map model) {
        try {
            //生成配置类
            Configuration configuration = new Configuration(Configuration.getVersion());
            //模板加载器
            StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
            stringTemplateLoader.putTemplate("template", template);
            //配置模板加载器
            configuration.setTemplateLoader(stringTemplateLoader);
            //获取模板
            Template template1 = configuration.getTemplate("template");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template1, model);
            return html;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //页面发布
    public ResponseResult postPage(String pageId){
        //执行页面静态化
        log.info("###开始静态化页面####");
        String pageHtml = this.getPageHtml(pageId);
        if(StringUtils.isEmpty(pageHtml)){
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_HTMLISNULL);
        }
        //保存静态化文件
        CmsPage cmsPage = saveHtml(pageId, pageHtml);
        //发送消息
        sendPostPage(pageId);
        return new ResponseResult(CommonCode.SUCCESS);
    }


    /**
     *
     * @description: 消息发送
     *
     * @param: pageId 页面id
     * @return: 保存后页面信息
     * @create_name: kikock
     * @create_date: 2021/2/1 15:42
     *
     **/
    private CmsPage sendPostPage(String pageId){
        //获取页面
        CmsPage cmsPage = this.findById(pageId);
        if(cmsPage == null){
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
        }
        //创建消息对象
        Map<String,String> msg =new HashMap<>();
        msg.put("pageId",pageId);
        //消息内容转换json串
        String jsonMap = JsonUtils.toJson(msg);
        //获取站点id作为routingKey
        String siteId = cmsPage.getSiteId();
        //消息发送 指定交换机,站点和内容
        this.rabbitTemplate.convertAndSend(RabbitmqConfig.EX_ROUTING_CMS_POSTPAGE,siteId, jsonMap);
        return cmsPage;
    }
    /**
     *
     * @description: 保存静态化文件
     *
     * @param: pageId 页面id
     * @param: content 静态化页面字符串
     * @return: 保存后页面信息
     * @create_name: kikock
     * @create_date: 2021/2/1 15:42
     *
     **/
    private CmsPage saveHtml(String pageId,String content){
        //查询页面
        Optional<CmsPage> optional = cmsPageRepository.findById(pageId);
        if(!optional.isPresent()){
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
        }
        CmsPage cmsPage = optional.get();
        //存储之前先删除
        String htmlFileId = cmsPage.getHtmlFileId();
        if(StringUtils.isNotEmpty(htmlFileId)){
            gridFsTemplate.delete(Query.query(Criteria.where("_id").is(htmlFileId)));
        }
        //保存html文件到GridFS
        InputStream inputStream = IOUtils.toInputStream(content);
        ObjectId objectId = gridFsTemplate.store(inputStream, cmsPage.getPageName());
        //文件id
        String fileId = objectId.toString();
        //将文件id存储到cmspage中
        cmsPage.setHtmlFileId(fileId);
        cmsPageRepository.save(cmsPage);
        return cmsPage;
    }
}
