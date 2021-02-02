package com.xuecheng.framework.domain.order;

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
@Table(name = "xc_orders_pay")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcOrdersPay implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "pay_number")
    private String payNumber;
    private String status;

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

    public String getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(String payNumber) {
        this.payNumber = payNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "XcOrdersPay{" +
                "id='" + id + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", payNumber='" + payNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
