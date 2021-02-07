package com.xuecheng.framework.domain.course.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * @project_name: xc-framework-model
 * @description: 删除课程响应
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class DeleteCourseResult extends ResponseResult {
    public DeleteCourseResult(ResultCode resultCode, String courseId) {
        super(resultCode);
        this.courseid = courseid;
    }

    private String courseid;

    @Override
    public String toString() {
        return "DeleteCourseResult{" +
                "courseid='" + courseid + '\'' +
                '}';
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }
}
