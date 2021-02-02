package com.xuecheng.framework.domain.order.request;

import com.xuecheng.framework.model.request.RequestData;

/**
 * Created by mrt on 2018/3/27.
 */
public class weixinPayInformRequest extends RequestData {

    //    返回状态码	（SUCCESS/FAIL此字段是通信标识）
    String return_code;
    //    返回信息
    String return_msg;
    //    公众账号ID
    String appid;
    //    商户号
    String mch_id;
    //    随机字符串
    String nonce_str;
    //    签名
    String sign;
    //    签名类型
    String sign_type;
    //    业务结果	（SUCCESS/FAIL）
    String result_code;
    //    错误代码
    String err_code;
    //    用户标识	（用户在商户appid下的唯一标识）
    String openid;
    //    交易类型	（JSAPI、NATIVE、APP）
    String trade_type;
    //    付款银行
    String bank_type;
    //    订单金额
    String total_fee;
    //    现金支付金额
    String cash_fee;
    //    微信支付订单号
    String transaction_id;
    //    商户订单号
    String out_trade_no;
    //    支付完成时间
    String time_end;

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(String cash_fee) {
        this.cash_fee = cash_fee;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    @Override
    public String toString() {
        return "weixinPayInformRequest{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", appid='" + appid + '\'' +
                ", mch_id='" + mch_id + '\'' +
                ", nonce_str='" + nonce_str + '\'' +
                ", sign='" + sign + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", result_code='" + result_code + '\'' +
                ", err_code='" + err_code + '\'' +
                ", openid='" + openid + '\'' +
                ", trade_type='" + trade_type + '\'' +
                ", bank_type='" + bank_type + '\'' +
                ", total_fee='" + total_fee + '\'' +
                ", cash_fee='" + cash_fee + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", time_end='" + time_end + '\'' +
                '}';
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

}
