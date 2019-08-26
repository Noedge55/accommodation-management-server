package org.noedge.domain;

import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 */
public class Result extends HashMap {
    private Integer retCode = -1;
    private String message="";
    private Object result;

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Result getResult(Integer retCode, String message, Object resultData){
        Result result = new Result();
        result.setRetCode(retCode);
        result.setMessage(message);
        result.setResult(resultData);
        return result;
    }
}
