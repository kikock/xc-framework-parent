package com.xuecheng.manage_cms.service;


import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage_cms.dao.SysDicthinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @project_name: xc-service-manage-cms
 * @description: 数据字典服务层
 * @create_name: kikock
 * @create_date: 2021-02-19 11:19
 **/
@Service
public class SysDicthinaryService {

    @Autowired
    SysDicthinaryRepository dicthinaryRepository;

    public SysDictionary getByType(String dType) {
        return dicthinaryRepository.findByDType(dType);
    }
}
