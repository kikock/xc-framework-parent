package com.xuecheng.framework.domain.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by mrt on 2018/3/30.
 */
@Document(collection = "user_test")
public class UserTest {


    @Id
    private String id;
    private String name;

    @Column(name = "create_time")
    private Date createTime;

    @Override
    public String toString() {
        return "UserTest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
