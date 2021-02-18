package com.xuecheng.framework.domain.media.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by admin on 2018/3/5.
 */
public class CheckChunkResult extends ResponseResult {

    @ApiModelProperty(value = "文件分块存在标记", example = "true", required = true)
    boolean fileExist;

    public CheckChunkResult(ResultCode resultCode, boolean fileExist) {
        super(resultCode);
        this.fileExist = fileExist;
    }

    public CheckChunkResult() {
    }

    @Override
    public String toString() {
        return "CheckChunkResult{" +
                "fileExist=" + fileExist +
                '}';
    }

    public boolean isFileExist() {
        return fileExist;
    }

    public void setFileExist(boolean fileExist) {
        this.fileExist = fileExist;
    }
}
