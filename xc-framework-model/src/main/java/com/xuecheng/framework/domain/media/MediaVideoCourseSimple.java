package com.xuecheng.framework.domain.media;


/**
 * Created by admin on 2018/3/5.
 */
public class MediaVideoCourseSimple {

    //课程id
    private String courseid;
    //章节id
    private String chapter;

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        return "MediaVideoCourseSimple{" +
                "courseid='" + courseid + '\'' +
                ", chapter='" + chapter + '\'' +
                '}';
    }
}
