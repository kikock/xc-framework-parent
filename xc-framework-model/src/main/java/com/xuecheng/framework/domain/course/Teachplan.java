package com.xuecheng.framework.domain.course;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @project_name: xc-framework-model
 * @description: 课程计划实体
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
@Entity
@Table(name = "teachplan")
//主键生成规则 uuid生成
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Teachplan implements Serializable {
    private static final long serialVersionUID = -916357110051689485L;
    //子--自连接 一对多
    @Transient
    List<Teachplan> children;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    // 课程名称
    private String pname;
    //下级id
    private String parentid;
    //层级
    private String grade;
    private String ptype;
    //说明
    private String description;
    private String courseid;
    //课程id
    private String status;
    private Integer orderby;
    private Double timelength;
    private String trylearn;
    //父--自连接 多对一
    @Transient
    private Teachplan parent;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Teachplan{" +
                "id='" + id + '\'' +
                ", pname='" + pname + '\'' +
                ", parentid='" + parentid + '\'' +
                ", grade='" + grade + '\'' +
                ", ptype='" + ptype + '\'' +
                ", description='" + description + '\'' +
                ", courseid='" + courseid + '\'' +
                ", status='" + status + '\'' +
                ", orderby=" + orderby +
                ", timelength=" + timelength +
                ", trylearn='" + trylearn + '\'' +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }

    public Teachplan getParent() {
        return parent;
    }

    public void setParent(Teachplan parent) {
        this.parent = parent;
    }

    public List<Teachplan> getChildren() {
        return children;
    }

    public void setChildren(List<Teachplan> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public Double getTimelength() {
        return timelength;
    }

    public void setTimelength(Double timelength) {
        this.timelength = timelength;
    }

    public String getTrylearn() {
        return trylearn;
    }

    public void setTrylearn(String trylearn) {
        this.trylearn = trylearn;
    }
}
