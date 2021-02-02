package com.xuecheng.framework.domain.system;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by admin on 2018/2/6.
 */
@Document(collection = "sys_dictionary")
public class SysDictionary {

    @Id
    private String id;

    @Field("d_name")
    private String dName;

    @Field("d_type")
    private String dType;

    @Field("d_value")
    private List<SysDictionaryValue> dValue;

    @Override
    public String toString() {
        return "SysDictionary{" +
                "id='" + id + '\'' +
                ", dName='" + dName + '\'' +
                ", dType='" + dType + '\'' +
                ", dValue=" + dValue +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public List<SysDictionaryValue> getdValue() {
        return dValue;
    }

    public void setdValue(List<SysDictionaryValue> dValue) {
        this.dValue = dValue;
    }
}
