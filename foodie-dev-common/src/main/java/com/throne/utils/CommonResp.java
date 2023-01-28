package com.throne.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonResp {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    @JsonIgnore
    private String ok;	// 不使用

    public static CommonResp build(Integer status, String msg, Object data) {
        return new CommonResp(status, msg, data);
    }

    public static CommonResp build(Integer status, String msg, Object data, String ok) {
        return new CommonResp(status, msg, data, ok);
    }

    public static CommonResp ok(Object data) {
        return new CommonResp(data);
    }

    public static CommonResp ok() {
        return new CommonResp(null);
    }

    public static CommonResp errorMsg(String msg) {
        return new CommonResp(500, msg, null);
    }

    public static CommonResp errorMap(Object data) {
        return new CommonResp(501, "error", data);
    }

    public static CommonResp errorTokenMsg(String msg) {
        return new CommonResp(502, msg, null);
    }

    public static CommonResp errorException(String msg) {
        return new CommonResp(555, msg, null);
    }

    public static CommonResp errorUserQQ(String msg) {
        return new CommonResp(556, msg, null);
    }

    public CommonResp() {

    }

    public CommonResp(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public CommonResp(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public CommonResp(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}
