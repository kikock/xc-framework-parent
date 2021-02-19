package com.xuecheng.framework.domain.ucenter.ext;

import com.xuecheng.framework.domain.course.Category;
import com.xuecheng.framework.domain.ucenter.XcMenu;

import java.util.List;

/**
 * Created by admin on 2018/3/20.
 */
public class XcMenuExt extends XcMenu {

    List<Category> children;


    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "XcMenuExt{" +
                "children=" + children +
                '}';
    }
}
