package com.zan.vo;

/**
 * VO :View Object :视图对象,专门提供给页面的java对象叫做VO
 * 此类专门用来给项目中的ajax进行数据返回的一个格式
 */
public class JsonResultVO {

    private int code;
    private String msg;

    public JsonResultVO() {
    }

    public JsonResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
