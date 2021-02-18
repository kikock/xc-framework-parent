package com.xuecheng.framework.domain.ucenter.ext;

/**
 * Created by mrt on 2018/5/21.
 */
public class UserTokenStore extends AuthToken {
    String userId;//用户id
    String utype;//用户类型
    String companyId;//用户所属企业信息

    public UserTokenStore() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "UserTokenStore{" +
                "userId='" + userId + '\'' +
                ", utype='" + utype + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
