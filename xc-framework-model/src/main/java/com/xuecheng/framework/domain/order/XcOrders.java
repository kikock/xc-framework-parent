package com.xuecheng.framework.domain.order;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2018/2/10.
 */
@Entity
@Table(name = "xc_orders")
@GenericGenerator(name = "jpa-assigned", strategy = "assigned")
public class XcOrders implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
    @Id
    @GeneratedValue(generator = "jpa-assigned")
    @Column(name = "order_number", length = 32)
    private String orderNumber;
    @Column(name = "initial_price")
    private Float initialPrice;
    private Float price;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    private String status;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "details")
    private String details;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "XcOrders{" +
                "orderNumber='" + orderNumber + '\'' +
                ", initialPrice=" + initialPrice +
                ", price=" + price +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", userId='" + userId + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Float getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Float initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
