package com.xuecheng.framework.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @project_name: xc-framework-utils
 * @description: Oauth2工具
 * @create_name: kikock
 * @create_date: 2021-01-21 16:23
 */
public class XcOauth2Util {

    public UserJwt getUserJwtFromHeader(HttpServletRequest request) {
        Map<String, String> jwtClaims = Oauth2Util.getJwtClaimsFromHeader(request);
        if (jwtClaims == null || StringUtils.isEmpty(jwtClaims.get("id"))) {
            return null;
        }
        UserJwt userJwt = new UserJwt();
        userJwt.setId(jwtClaims.get("id"));
        userJwt.setName(jwtClaims.get("name"));
        userJwt.setCompanyId(jwtClaims.get("companyId"));
        userJwt.setUtype(jwtClaims.get("utype"));
        userJwt.setUserpic(jwtClaims.get("userpic"));
        return userJwt;
    }


    public class UserJwt {
        private String id;
        private String name;
        private String userpic;
        private String utype;
        private String companyId;

        @Override
        public String toString() {
            return "UserJwt{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", userpic='" + userpic + '\'' +
                    ", utype='" + utype + '\'' +
                    ", companyId='" + companyId + '\'' +
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

        public String getUserpic() {
            return userpic;
        }

        public void setUserpic(String userpic) {
            this.userpic = userpic;
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
    }


}
