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
@Table(name = "xc_orders_detail")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcOrdersDetail implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "item_id")
    private String itemId;
    @Column(name = "item_num")
    private Integer itemNum;
    @Column(name = "item_price")
    private Float itemPrice;
    private String valid;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
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

    @Override
    public String toString() {
        return "XcOrdersDetail{" +
                "id='" + id + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", itemId='" + itemId + '\'' +
                ", itemNum=" + itemNum +
                ", itemPrice=" + itemPrice +
                ", valid='" + valid + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
