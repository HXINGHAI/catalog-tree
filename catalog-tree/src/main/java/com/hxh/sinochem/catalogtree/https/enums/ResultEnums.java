package com.hxh.sinochem.catalogtree.https.enums;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/24 9:31
 * @Description:
 */

public enum ResultEnums {

    RESULT_SUCCESS("200","参数结果"),

    PARAMS_ERROR("404","请输入正确的参数");

    private String code;
    private String msg;

    ResultEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
