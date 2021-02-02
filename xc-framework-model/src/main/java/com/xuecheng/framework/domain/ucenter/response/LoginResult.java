package com.xuecheng.framework.domain.ucenter.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * Created by mrt on 2018/5/21.
 */

public class LoginResult extends ResponseResult {
    public LoginResult(ResultCode resultCode, String token) {
        super(resultCode);
        this.token = token;
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "token='" + token + '\'' +
                '}';
    }

    public LoginResult() {
    }
}
