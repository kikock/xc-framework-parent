package com.xuecheng.framework.domain.order.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * Created by mrt on 2018/3/27.
 */
public class PayQrcodeResult extends ResponseResult {
    private String codeUrl;
    private Float money;
    private String orderNumber;

    public PayQrcodeResult(ResultCode resultCode) {
        super(resultCode);
    }

    @Override
    public String toString() {
        return "PayQrcodeResult{" +
                "codeUrl='" + codeUrl + '\'' +
                ", money=" + money +
                ", orderNumber='" + orderNumber + '\'' +
                '}';
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
