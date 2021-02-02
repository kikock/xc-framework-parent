package com.xuecheng.framework.domain.order.response;

import com.xuecheng.framework.domain.order.XcOrdersPay;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * Created by mrt on 2018/3/27.
 */
public class PayOrderResult extends ResponseResult {
    public PayOrderResult(ResultCode resultCode) {
        super(resultCode);
    }

    public PayOrderResult(ResultCode resultCode, XcOrdersPay xcOrdersPay) {
        super(resultCode);
        this.xcOrdersPay = xcOrdersPay;
    }

    private XcOrdersPay xcOrdersPay;
    private String orderNumber;

    //当tradeState为NOTPAY（未支付）时显示支付二维码
    private String codeUrl;
    private Float money;

    public XcOrdersPay getXcOrdersPay() {
        return xcOrdersPay;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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

    public void setXcOrdersPay(XcOrdersPay xcOrdersPay) {
        this.xcOrdersPay = xcOrdersPay;
    }

    @Override
    public String toString() {
        return "PayOrderResult{" +
                "xcOrdersPay=" + xcOrdersPay +
                ", orderNumber='" + orderNumber + '\'' +
                ", codeUrl='" + codeUrl + '\'' +
                ", money=" + money +
                '}';
    }
}
