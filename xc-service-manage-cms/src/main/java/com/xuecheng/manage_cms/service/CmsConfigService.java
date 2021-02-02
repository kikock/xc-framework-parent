package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.domain.cms.request.QueryCmsConfigRequest;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsConfigResult;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsConfigRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 *
 * @project_name: xc-framework-parent
 * @description: 页面模板服务层
 * @create_name: kikock
 * @create_date: 2021-01-19 17:31
 *
 **/
@Service
public class CmsConfigService {

    private static final Logger log = LoggerFactory.getLogger(CmsConfigService.class);


    @Autowired
    CmsConfigRepository cmsConfigRepository;



    /**
     * 根据id查询cms配置管理信息
     *
     * @param id cmsConfig模板id
     * @return  模板消息
     */
    public CmsConfig getConfigById(String id) {
        Optional<CmsConfig> optional = cmsConfigRepository.findById(id);
        if (optional.isPresent()) {
            CmsConfig cmsConfig = optional.get();
            return cmsConfig;
        }
        return null;
    }
    /**
     * 页面查询方法
     *
     * @param page             页码，从1开始记数
     * @param size             每页记录数
     * @param queryCmsConfigRequest 查询条件
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryCmsConfigRequest queryCmsConfigRequest) {
        if (Objects.isNull(queryCmsConfigRequest)) {
            queryCmsConfigRequest = new QueryCmsConfigRequest();
        }

        // 增加自定义条件
        //条件匹配器  模板名称模糊查询
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        //查询条件 设置条件值
        CmsConfig cmsConfig = new CmsConfig();
        // 页面名称
        if (StringUtils.isNotBlank(queryCmsConfigRequest.getName())) {
            cmsConfig.setName(queryCmsConfigRequest.getName());
        }

        // 条件对象实例
        Example<CmsConfig> example = Example.of(cmsConfig, exampleMatcher);
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
        Page<CmsConfig> all = cmsConfigRepository.findAll(example, pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 页面添加
     *
     * @param cmsConfig 模板参数
     * @return
     */
    public CmsConfigResult add(CmsConfig cmsConfig) {
        CmsConfig cmsConfig1 = cmsConfigRepository.findByName(cmsConfig.getName());
        if (Objects.nonNull(cmsConfig1)) {
            //已经存在此模板抛出异常
            ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        cmsConfig.setId(null);
        cmsConfigRepository.save(cmsConfig);
        return new CmsConfigResult(CommonCode.SUCCESS, cmsConfig);
    }
    //
    // /**
    //  * 根据id 获取页面
    //  *
    //  * @param id 页面参数
    //  * @return
    //  */
    // public CmsPage findById(String id) {
    //     Optional<CmsPage> optional = cmsPageRepository.findById(id);
    //     if (optional.isPresent()) {
    //         CmsPage cmsPage = optional.get();
    //         return cmsPage;
    //     }
    //     return null;
    // }
    //
    // /**
    //  * 页面修改
    //  *
    //  * @param id      页面id
    //  * @param cmsPage 页面参数
    //  * @return
    //  */
    // public CmsPageResult edit(String id, CmsPage cmsPage) {
    //     CmsPage one = findById(id);
    //     if (Objects.nonNull(one)) {
    //         //更新模板id
    //         one.setTemplateId(cmsPage.getTemplateId());
    //         //更新所属站点
    //         one.setSiteId(cmsPage.getSiteId());
    //         //更新页面别名
    //         one.setPageAliase(cmsPage.getPageAliase());
    //         //更新页面名称
    //         one.setPageName(cmsPage.getPageName());
    //         //更新访问路径
    //         one.setPageWebPath(cmsPage.getPageWebPath());
    //         //更新物理路径
    //         one.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
    //         //更新url路径
    //         one.setDataUrl(cmsPage.getDataUrl());
    //         //执行更新
    //         CmsPage save = cmsPageRepository.save(one);
    //         if (save != null) {
    //             //返回成功
    //             CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.SUCCESS, save);
    //             return cmsPageResult;
    //         }
    //     }
    //     //返回失败
    //     return new CmsPageResult(CommonCode.FAIL, null);
    // }
    //
    // /**
    //  * 删除页面
    //  *
    //  * @param id 页面id
    //  * @return
    //  */
    // public ResponseResult del(String id) {
    //     Optional<CmsPage> optional = cmsPageRepository.findById(id);
    //     if (optional.isPresent()) {
    //         cmsPageRepository.deleteById(id);
    //         return new ResponseResult(CommonCode.SUCCESS);
    //     }
    //     return new ResponseResult(CommonCode.FAIL);
    //
    // }





}
