package com.hxh.sinochem.catalogtree.https;

import com.hxh.sinochem.catalogtree.https.enums.ResultEnums;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/24 9:23
 * @Description:
 */

public final class httpResponse<T> {
    private String code;
    private String msg;
    private T result;


    public httpResponse(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public httpResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public httpResponse(String code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public static <T> httpResponse<T> error(String code,String msg){
        return new httpResponse<>(code,msg);
    }

    public static <T> httpResponse<T> success(){
        return new httpResponse<>(ResultEnums.RESULT_SUCCESS.getCode(),ResultEnums.RESULT_SUCCESS.getMsg());
    }

    public static <T> httpResponse<T> success(T result){
        return new httpResponse<>(ResultEnums.RESULT_SUCCESS.getCode(),ResultEnums.RESULT_SUCCESS.getMsg(),result);
    }
}
