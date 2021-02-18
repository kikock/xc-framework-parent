package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.domain.cms.CmsConfigModel;
import com.xuecheng.framework.domain.cms.request.QueryCmsConfigRequest;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsConfigResult;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.utils.JsonUtils;
import com.xuecheng.manage_cms.dao.CmsConfigRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @project_name: xc-framework-parent
 * @description: 页面模板服务层
 * @create_name: kikock
 * @create_date: 2021-01-19 17:31
 **/
@Service
public class CmsConfigService {

    private static final Logger log = LoggerFactory.getLogger(CmsConfigService.class);


    @Resource
    CmsConfigRepository cmsConfigRepository;


    /**
     * 根据id查询cms配置管理信息
     *
     * @param id cmsConfig模板id
     * @return 模板消息
     */
    public CmsConfig getConfigById(String id) {
        Optional<CmsConfig> optional = cmsConfigRepository.findById(id);
        return optional.orElse(null);
    }

    /**
     * 页面查询方法
     *
     * @param page                  页码，从1开始记数
     * @param size                  每页记录数
     * @param queryCmsConfigRequest 查询条件
     * @return QueryResponseResult
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
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    /**
     * 添加模板类型
     *
     * @param cmsConfig 模板参数
     * @return CmsConfigResult
     */
    public CmsConfigResult add(CmsConfig cmsConfig) {
        CmsConfig cmsConfig1 = cmsConfigRepository.findByName(cmsConfig.getName());
        if (Objects.nonNull(cmsConfig1)) {
            //已经存在此模板抛出异常---模板名称已经存在
            ExceptionCast.cast(CmsCode.CMS_ADDCONFIG_EXISTSNAME);
        }
        if (StringUtils.isBlank(cmsConfig.getId())) {
            cmsConfig.setId(null);
            cmsConfigRepository.save(cmsConfig);
        }
        Optional<CmsConfig> optional = cmsConfigRepository.findById(cmsConfig.getId());
        if (optional.isPresent()) {
            CmsConfig cmsConfig2 = optional.get();
            cmsConfig.setModel(cmsConfig2.getModel());
            cmsConfigRepository.save(cmsConfig);
            return new CmsConfigResult(CommonCode.SUCCESS, cmsConfig);
        }
        return new CmsConfigResult(CommonCode.FAIL, null);
    }

    /**
     * @description: 添加模板
     * @param: id
     * @param: configModel
     * @return: CmsConfigResult
     * @create_name: kikock
     * @create_date: 2021/2/9 10:51
     **/
    public CmsConfigResult addModel(String id, CmsConfigModel configModel) {
        String jsonInput = configModel.getValue();

        if (StringUtils.isNoneBlank(jsonInput) && !JsonUtils.validate(jsonInput)) {
            //不为空且json数据校验不成功 抛出异常
            ExceptionCast.cast(CommonCode.JSONCHECK_ERROR);
        }
        //获取模板类型
        Optional<CmsConfig> optional = cmsConfigRepository.findById(id);
        if (!optional.isPresent()) {
            //模板类型不存在 抛出异常
            ExceptionCast.cast(CmsCode.CMS_ADDCONFIG_TEMPLATEISNULL);
        }
        // 获取模板类型中的模板
        CmsConfig cmsConfig = optional.get();
        List<CmsConfigModel> model = cmsConfig.getModel();
        if (CollectionUtils.isEmpty(model)) {
            model = new ArrayList<>();
            model.add(configModel);
            cmsConfig.setModel(model);
        } else {
            List<CmsConfigModel> newMorel = new ArrayList<>();
            for (CmsConfigModel i : model) {
                if (!i.getKey().equals(configModel.getKey())) {
                    newMorel.add(i);
                } else {
                    newMorel.add(configModel);
                }
            }
            cmsConfig.setModel(newMorel);
        }
        cmsConfigRepository.save(cmsConfig);
        return new CmsConfigResult(CommonCode.SUCCESS, cmsConfig);
    }

    /**
     * 模板修改
     *
     * @param cmsConfig 页面模板
     * @return CmsConfigResult
     */
    public CmsConfigResult edit(CmsConfig cmsConfig) {
        Optional<CmsConfig> optional = cmsConfigRepository.findById(cmsConfig.getId());
        if (!optional.isPresent()) {
            return new CmsConfigResult(CommonCode.FAIL, null);
        }

        CmsConfig save = cmsConfigRepository.save(cmsConfig);
        return new CmsConfigResult(CommonCode.SUCCESS, save);
    }


    /**
     * 删除模板
     *
     * @param id 页面id
     * @return ResponseResult
     */
    public ResponseResult del(String id) {
        Optional<CmsConfig> optional = cmsConfigRepository.findById(id);
        if (optional.isPresent()) {
            cmsConfigRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);

    }

    /**
     * 删除模板详情
     *
     * @param id 页面id
     * @return ResponseResult
     */
    public ResponseResult delModel(String id, String key) {
        Optional<CmsConfig> optional = cmsConfigRepository.findById(id);
        if (optional.isPresent()) {
            CmsConfig cmsConfig = optional.get();
            List<CmsConfigModel> model = cmsConfig.getModel();
            List<CmsConfigModel> newModel = new ArrayList<>();
            for (CmsConfigModel i : model) {
                if (!i.getKey().equals(key)) {
                    newModel.add(i);
                }
            }
            cmsConfig.setModel(newModel);
            cmsConfigRepository.save(cmsConfig);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);

    }


}
