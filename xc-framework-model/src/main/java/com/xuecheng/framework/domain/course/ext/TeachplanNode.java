package com.xuecheng.framework.domain.course.ext;

import com.xuecheng.framework.domain.course.Teachplan;

import java.util.List;

/**
 * Created by admin on 2018/2/7.
 */
public class TeachplanNode extends Teachplan {

    List<TeachplanNode> children;

    @Override
    public String toString() {
        return "TeachplanNode{" +
                "children=" + children +
                '}';
    }

    public List<TeachplanNode> getChildren() {
        return children;
    }

    public void setChildren(List<TeachplanNode> children) {
        this.children = children;
    }
}
