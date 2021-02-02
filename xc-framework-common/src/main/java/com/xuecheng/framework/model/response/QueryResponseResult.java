package com.xuecheng.framework.model.response;


public class QueryResponseResult extends ResponseResult {

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
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
