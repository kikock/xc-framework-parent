package com.xuecheng.framework.domain.system;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by admin on 2018/2/6.
 */
public class SysDictionaryValue {

    @Field("sd_id")
    private String sdId;

    @Field("sd_name")
    private String sdName;

    @Field("sd_status")
    private String sdStatus;

    @Override
    public String toString() {
        return "SysDictionaryValue{" +
                "sdId='" + sdId + '\'' +
                ", sdName='" + sdName + '\'' +
                ", sdStatus='" + sdStatus + '\'' +
                '}';
    }

    public String getSdId() {
        return sdId;
    }

    public void setSdId(String sdId) {
        this.sdId = sdId;
    }

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName;
    }

    public String getSdStatus() {
        return sdStatus;
    }

    public void setSdStatus(String sdStatus) {
        this.sdStatus = sdStatus;
    }
}
