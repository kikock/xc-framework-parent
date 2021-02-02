package com.xuecheng.framework.domain.course.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * Created by mrt on 2018/3/20.
 */

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
