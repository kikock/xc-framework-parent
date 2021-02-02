package com.xuecheng.framework.domain.ucenter;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by admin on 2018/2/10.
 */

@Entity
@Table(name = "xc_company_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcCompanyUser implements Serializable {
    private static final long serialVersionUID = -916357110051689786L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(name = "company_id")
    private String companyId;
    @Column(name = "user_id")
    private String userId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "XcCompanyUser{" +
                "id='" + id + '\'' +
                ", companyId='" + companyId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
