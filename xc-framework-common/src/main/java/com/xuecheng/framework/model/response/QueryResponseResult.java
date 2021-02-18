package com.xuecheng.framework.model.response;

/**
 * @project_name: xc-framework-common
 * @description: 响应结果(带数据)
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class QueryResponseResult extends ResponseResult {
    //列表数据
    QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode, QueryResult queryResult) {
        super(resultCode);
        this.queryResult = queryResult;
    }

    public QueryResponseResult() {
    }

    public QueryResult getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(QueryResult queryResult) {
        this.queryResult = queryResult;
    }

    @Override
    public String toString() {
        return "QueryResponseResult{" +
                "queryResult=" + queryResult +
                '}';
    }
}
