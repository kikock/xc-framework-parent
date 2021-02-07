package com.xuecheng.framework.domain.course.request;

import com.xuecheng.framework.model.request.RequestData;

/**
 * @project_name: xc-framework-model
 * @description: 课程请求参数
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class CourseListRequest extends RequestData {
    //公司Id
    private String companyId;

    @Override
    public String toString() {
        return "CourseListRequest{" +
                "companyId='" + companyId + '\'' +
                '}';
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
