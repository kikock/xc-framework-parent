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
@Table(name = "xc_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcRole {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "roleCode")
    private String role_code;
    private String description;
    private String status;
    @Column(name = "createTime")
    private Date create_time;
    @Column(name = "update_time")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "XcRole{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", role_code='" + role_code + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", create_time=" + create_time +
                ", updateTime=" + updateTime +
                '}';
    }
}
