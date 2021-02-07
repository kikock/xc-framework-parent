package com.xuecheng.framework.domain.course;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @project_name: xc-framework-model
 * @description: 课程计划视频扩展参数
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
@Entity
@Table(name = "teachplan_media")
@GenericGenerator(name = "jpa-assigned", strategy = "assigned")
public class TeachplanMedia implements Serializable {
    private static final long serialVersionUID = -916357110051689485L;
    @Id
    @GeneratedValue(generator = "jpa-assigned")
    @Column(name = "teachplan_id")
    private String teachplanId;

    @Column(name = "media_id")
    private String mediaId;

    @Column(name = "media_fileoriginalname")
    private String mediaFileOriginalName;

    @Column(name = "media_url")
    private String mediaUrl;
    private String courseId;

    @Override
    public String toString() {
        return "TeachplanMedia{" +
                "teachplanId='" + teachplanId + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", mediaFileOriginalName='" + mediaFileOriginalName + '\'' +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
}
