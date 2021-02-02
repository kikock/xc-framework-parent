package com.xuecheng.framework.domain.course.request;

import com.xuecheng.framework.model.request.RequestData;

/**
 * Created by mrt on 2018/4/13.
 */
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
