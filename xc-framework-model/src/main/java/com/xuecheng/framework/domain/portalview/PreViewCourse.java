package com.xuecheng.framework.domain.portalview;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.report.ReportCourse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by admin on 2018/2/27.
 */
@Document(collection = "pre_view_course")
public class PreViewCourse implements Serializable {

    @Id
    private String id;
    private CourseBase courseBase;
    private CourseMarket courseMarket;
    private CoursePic coursePic;
    //课程统计信息
    private ReportCourse reportCourse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CourseBase getCourseBase() {
        return courseBase;
    }

    public void setCourseBase(CourseBase courseBase) {
        this.courseBase = courseBase;
    }

    public CourseMarket getCourseMarket() {
        return courseMarket;
    }

    public void setCourseMarket(CourseMarket courseMarket) {
        this.courseMarket = courseMarket;
    }

    public CoursePic getCoursePic() {
        return coursePic;
    }

    public void setCoursePic(CoursePic coursePic) {
        this.coursePic = coursePic;
    }


    public ReportCourse getReportCourse() {
        return reportCourse;
    }

    public void setReportCourse(ReportCourse reportCourse) {
        this.reportCourse = reportCourse;
    }

    @Override
    public String toString() {
        return "PreViewCourse{" +
                "id='" + id + '\'' +
                ", courseBase=" + courseBase +
                ", courseMarket=" + courseMarket +
                ", coursePic=" + coursePic +
                ", reportCourse=" + reportCourse +
                '}';
    }
}
