package org.db;

import org.pojo.QueryVO;

public class Query {
    public static QueryVO parse(String operationStr){
        if(operationStr==null || operationStr.trim().length()==0){
            return null;
        }

        String[] operationDetail = operationStr.split(" ");
        String operationName = operationDetail[0];
        String key=null;
        String value=null;

        if(operationDetail.length>1){
            key=operationDetail[1];
        }
        if(operationDetail.length>2){
            value=operationDetail[2];
        }
        QueryVO vo = new QueryVO.Builder(operationName)
                .key(key)
                .value(value)
                .build();
        return vo;
    }
}
