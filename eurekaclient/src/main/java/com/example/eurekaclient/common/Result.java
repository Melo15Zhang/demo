package com.example.eurekaclient.common;

public class Result {
    /**
     * 参考 {@link com.example.eurekaclient.common.BizCode}
     * */
    private int code;
    private String msg;
    private Object data;
    private String time;

    public Result(Integer code) {
        this.code = code;
    }

    public Result(Integer code, String msg) {
        this(code);
        this.msg = msg;
    }

    public Result(Integer code, String msg,Object data) {
        this(code,msg);
        this.data = data;
    }

    public static Result successResult(Object data) {
        Result result = ResultFactory.getResult(BizCode.SUCCESS_CODE);
        result.setData(data);
        return result;
    }
    public static Result serverResult() {
        Result result = ResultFactory.getResult(BizCode.SERVER_ERROR_CODE);
        result.setMsg(BizCode.SERVER_ERROR_MSG);
        return result;
    }
    public static Result argResult() {
        Result result = ResultFactory.getResult(BizCode.ARG_ERROR_CODE);
        result.setMsg(BizCode.ARG_ERROR_MSG);
        return result;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
