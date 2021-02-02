package com.xuecheng.framework.domain.order.request;

import com.xuecheng.framework.model.request.RequestData;

/**
 * Created by mrt on 2018/3/26.
 */
public class CreateOrderRequest extends RequestData {

    String courseId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "courseId='" + courseId + '\'' +
                '}';
    }
}
