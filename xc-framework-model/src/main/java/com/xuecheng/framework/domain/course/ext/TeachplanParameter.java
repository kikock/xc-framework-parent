package com.xuecheng.framework.domain.course.ext;

import com.xuecheng.framework.domain.course.Teachplan;

import java.util.List;

/**
 * Created by admin on 2018/2/7.
 */
public class TeachplanParameter extends Teachplan {

    //二级分类ids
    List<String> bIds;
    //三级分类ids
    List<String> cIds;

    @Override
    public String toString() {
        return "TeachplanParameter{" +
                "bIds=" + bIds +
                ", cIds=" + cIds +
                '}';
    }

    public List<String> getbIds() {
        return bIds;
    }

    public void setbIds(List<String> bIds) {
        this.bIds = bIds;
    }

    public List<String> getcIds() {
        return cIds;
    }

    public void setcIds(List<String> cIds) {
        this.cIds = cIds;
    }
}
