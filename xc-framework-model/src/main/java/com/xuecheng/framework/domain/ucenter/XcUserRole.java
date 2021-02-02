package com.xuecheng.framework.domain.ucenter;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by admin on 2018/3/19.
 */

@Entity
@Table(name = "xc_user_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcUserRole {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;

    @Column(name = "user_id")
    private String userId;
    @Column(name = "role_id")
    private String roleId;
    private String creator;
    @Column(name = "create_time")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "XcUserRole{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
