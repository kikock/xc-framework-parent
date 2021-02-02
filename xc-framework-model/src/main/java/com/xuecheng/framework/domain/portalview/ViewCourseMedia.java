package com.xuecheng.framework.domain.portalview;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by admin on 2018/2/27.
 */
@Document(collection = "view_course_media")
public class ViewCourseMedia implements Serializable {

    @Id
    @Column(name = "teachplan_id")
    private String teachplanId;

    @Column(name = "media_id")
    private String mediaId;

    @Column(name = "media_fileoriginalname")
    private String mediaFileOriginalName;

    @Column(name = "media_url")
    private String mediaUrl;
    private String courseId;

    public String getTeachplanId() {
        return teachplanId;
    }

    public void setTeachplanId(String teachplanId) {
        this.teachplanId = teachplanId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaFileOriginalName() {
        return mediaFileOriginalName;
    }

    public void setMediaFileOriginalName(String mediaFileOriginalName) {
        this.mediaFileOriginalName = mediaFileOriginalName;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "ViewCourseMedia{" +
                "teachplanId='" + teachplanId + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", mediaFileOriginalName='" + mediaFileOriginalName + '\'' +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
