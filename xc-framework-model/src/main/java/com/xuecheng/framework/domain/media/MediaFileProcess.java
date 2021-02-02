package com.xuecheng.framework.domain.media;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 10:04.
 * @Modified By:
 */
public class MediaFileProcess {

    //错误信息
    private String errormsg;

    @Override
    public String toString() {
        return "MediaFileProcess{" +
                "errormsg='" + errormsg + '\'' +
                '}';
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
}
