package com.xuecheng.framework.domain.media.response;

import com.xuecheng.framework.domain.media.MediaFile;
import com.xuecheng.framework.domain.media.MediaVideoCourse;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * Created by admin on 2018/3/5.
 */
public class MediaCourseResult extends ResponseResult {
    public MediaCourseResult(ResultCode resultCode, MediaVideoCourse mediaVideoCourse) {
        super(resultCode);
        this.mediaVideoCourse = mediaVideoCourse;
    }

    MediaFile mediaVideo;
    MediaVideoCourse mediaVideoCourse;

    public MediaCourseResult() {
    }

    @Override
    public String toString() {
        return "MediaCourseResult{" +
                "mediaVideo=" + mediaVideo +
                ", mediaVideoCourse=" + mediaVideoCourse +
                '}';
    }

    public MediaFile getMediaVideo() {
        return mediaVideo;
    }

    public void setMediaVideo(MediaFile mediaVideo) {
        this.mediaVideo = mediaVideo;
    }

    public MediaVideoCourse getMediaVideoCourse() {
        return mediaVideoCourse;
    }

    public void setMediaVideoCourse(MediaVideoCourse mediaVideoCourse) {
        this.mediaVideoCourse = mediaVideoCourse;
    }
}
