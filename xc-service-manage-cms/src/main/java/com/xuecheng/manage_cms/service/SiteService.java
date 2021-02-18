package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.CmsSiteServer;
import com.xuecheng.framework.domain.cms.request.QuerySiteRequest;
import com.xuecheng.framework.domain.cms.response.CmsSiteCode;
import com.xuecheng.framework.domain.cms.response.CmsSiteResult;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import com.xuecheng.manage_cms.dao.CmsSiteServiceRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @project_name: xc-framework-parent
 * @description: 站点服务
 * @create_name: kikock
 * @create_date: 2021-02-07 14:31
 **/
@Service
public class SiteService {

    @Autowired
    CmsSiteRepository cmsSiteRepository;

    @Autowired
    CmsSiteServiceRepository cmsSiteServiceRepository;

    /**
     * 页面查询方法
     *
     * @param page             页码，从1开始记数
     * @param size             每页记录数
     * @param querySiteRequest 查询条件
     * @return
     */
    public QueryResponseResult findList(int page, int size, QuerySiteRequest querySiteRequest) {
        if (Objects.isNull(querySiteRequest)) {
            querySiteRequest = new QuerySiteRequest();
        }

        // 增加自定义条件
        //条件匹配器   站点名称模糊查询
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("siteName", ExampleMatcher.GenericPropertyMatchers.contains());

        //查询条件 设置条件值
        CmsSite cmsSite = new CmsSite();

        // 站点ID
        if (StringUtils.isNotBlank(querySiteRequest.getSiteId())) {
            cmsSite.setSiteId(querySiteRequest.getSiteId());
        }
        // 站点域名
        if (StringUtils.isNotBlank(querySiteRequest.getSiteDomain())) {
            cmsSite.setSiteDomain(querySiteRequest.getSiteDomain());
        }

        // 条件对象实例
        Example<CmsSite> example = Example.of(cmsSite, exampleMatcher);
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
        Page<CmsSite> all = cmsSiteRepository.findAll(example, pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 添加站点
     *
     * @param querySiteRequest 页面参数
     * @return
     */
    public CmsSiteResult add(QuerySiteRequest querySiteRequest) {
        CmsSite cmsSite = new CmsSite();
        CmsSiteServer cmsSiteServer = new CmsSiteServer();
        CmsSite oldCmsSite = cmsSiteRepository.findBySiteName(querySiteRequest.getSiteName());
        if (Objects.nonNull(oldCmsSite)) {
            //站点名称已经存在
            ExceptionCast.cast(CmsSiteCode.SITE_ADDSITE_EXISTSNAME);
        }
        CmsSiteServer oldCmsSiteServer = cmsSiteServiceRepository.findByServerName(querySiteRequest.getServerName());
        if (Objects.nonNull(oldCmsSiteServer)) {
            //站点名称已经存在
            ExceptionCast.cast(CmsSiteCode.SITE_ADDSITESERVICE_EXISTSNAME);
        }
        //配置参数保存
        //站点属性
        cmsSite.setSiteId(null);
        cmsSite.setSiteName(querySiteRequest.getSiteName());
        cmsSite.setSiteDomain(querySiteRequest.getSiteDomain());
        cmsSite.setSitePort(querySiteRequest.getSitePort());
        cmsSite.setSiteWebPath(querySiteRequest.getSiteWebPath());
        cmsSite.setSiteCreateTime(querySiteRequest.getSiteCreateTime());
        cmsSite.setSitePhysicalPath(querySiteRequest.getSitePhysicalPath());
        //保存
        cmsSiteRepository.save(cmsSite);
        //保存服务器信息
        cmsSiteServer.setServerId(null);
        cmsSiteServer.setSiteId(cmsSite.getSiteId());
        cmsSiteServer.setIp(querySiteRequest.getIp());
        cmsSiteServer.setPort(querySiteRequest.getPort());
        cmsSiteServer.setWebPath(querySiteRequest.getWebPath());
        cmsSiteServer.setServerName(querySiteRequest.getServerName());
        cmsSiteServer.setUploadPath(querySiteRequest.getUploadPath());
        cmsSiteServer.setUseType(querySiteRequest.getUseType());
        cmsSiteServiceRepository.save(cmsSiteServer);
        return new CmsSiteResult(CommonCode.SUCCESS, cmsSite, cmsSiteServer);
    }


    /**
     * 站点删除
     *
     * @param id 站点id
     * @return ResponseResult
     */
    public ResponseResult del(String id) {
        Optional<CmsSite> optionalCmsSite = cmsSiteRepository.findById(id);
        // 查询站点
        if (optionalCmsSite.isPresent()) {
            //查询站点服务器
            List<CmsSiteServer> cmsSiteServerList = cmsSiteServiceRepository.findBySiteId(id);
            //先删除站点服务器数据
            cmsSiteServerList.forEach(siteServer -> {
                cmsSiteServiceRepository.delete(siteServer);
            });
            //再删除站点
            cmsSiteRepository.delete(optionalCmsSite.get());
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);

    }

}
