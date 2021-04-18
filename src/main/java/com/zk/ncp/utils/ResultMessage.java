package com.zk.ncp.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultMessage implements Serializable {

    private static final long serialVersionUID = 6926996388480739504L;

    private static final String RESPONSE_CODE_SUCCESS_DEFAULT = "S_SYS_000000";

    private static final String RESPONSE_CODE_ERROR_DEFAULT = "E_SYS_000000";

    private static final String SUCCESS_MSG = "操作成功";

    private static final String FAIL_MSG = "操作失败";

    private static final String SUCCESS = "SUCCESS";

    private static final String FAIL = "FAIL";

    /**
     * 响应码
     */
    protected String code;
    /**
     * 响应消息
     */
    protected String msg;
    /**
     * 响应数据
     */
    protected Object data;

    public static ResultMessage success() {
        ResultMessage result = new ResultMessage();
        result.setCode(ResultMessage.RESPONSE_CODE_SUCCESS_DEFAULT);
        result.setData(ResultMessage.SUCCESS);
        result.setMsg(ResultMessage.SUCCESS_MSG);
        return result;
    }

    public static ResultMessage success(Object data) {
        ResultMessage result = new ResultMessage();
        result.setCode(ResultMessage.RESPONSE_CODE_SUCCESS_DEFAULT);
        result.setData(data);
        result.setMsg(ResultMessage.SUCCESS_MSG);
        return result;
    }

    public static ResultMessage fail() {
        ResultMessage result = new ResultMessage();
        result.setCode(ResultMessage.RESPONSE_CODE_ERROR_DEFAULT);
        result.setData(ResultMessage.FAIL);
        result.setMsg(ResultMessage.FAIL_MSG);
        return result;
    }

    public static ResultMessage fail(Object data) {
        ResultMessage result = new ResultMessage();
        result.setCode(ResultMessage.RESPONSE_CODE_ERROR_DEFAULT);
        result.setData(data);
        result.setMsg(ResultMessage.FAIL_MSG);
        return result;
    }

}
