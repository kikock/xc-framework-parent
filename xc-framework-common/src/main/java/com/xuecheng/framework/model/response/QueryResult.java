package com.xuecheng.framework.model.response;

import java.util.List;

/**
 * @project_name: xc-framework-common
 * @description: 响应结果列表数据信息
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class QueryResult<T> {
    //数据列表
    private List<T> list;
    //数据总数
    private long total;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "list=" + list +
                ", total=" + total +
                '}';
    }
}
