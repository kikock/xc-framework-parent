package com.xuecheng.framework.domain.media.response;

import com.xuecheng.framework.domain.media.MediaFile;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * Created by mrt on 2018/3/31.
 */

public class MediaFileResult extends ResponseResult {
    MediaFile mediaFile;

    public MediaFileResult(ResultCode resultCode, MediaFile mediaFile) {
        super(resultCode);
        this.mediaFile = mediaFile;
    }

    public MediaFileResult() {
    }

    @Override
    public String toString() {
        return "MediaFileResult{" +
                "mediaFile=" + mediaFile +
                '}';
    }

    public MediaFile getMediaFile() {
        return mediaFile;
    }

    public void setMediaFile(MediaFile mediaFile) {
        this.mediaFile = mediaFile;
    }
}
