package com.xuecheng.framework.domain.order.response;

import com.xuecheng.framework.domain.order.XcOrders;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * Created by mrt on 2018/3/26.
 */
public class OrderResult extends ResponseResult {
    private XcOrders xcOrders;

    public OrderResult(ResultCode resultCode, XcOrders xcOrders) {
        super(resultCode);
        this.xcOrders = xcOrders;
    }

    public XcOrders getXcOrders() {
        return xcOrders;
    }

    public void setXcOrders(XcOrders xcOrders) {
        this.xcOrders = xcOrders;
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "xcOrders=" + xcOrders +
                '}';
    }
}
