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
@Table(name = "xc_permission")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcPermission {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(name = "roleId")
    private String role_id;
    @Column(name = "menuId")
    private String menu_id;
    @Column(name = "createTime")
    private Date create_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "XcPermission{" +
                "id='" + id + '\'' +
                ", role_id='" + role_id + '\'' +
                ", menu_id='" + menu_id + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
