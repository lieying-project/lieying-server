package org.lieying.core;

import org.apache.poi.ss.formula.functions.T;

/*
* 响应结果生成工具
* */
public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String EDIT_SUCCESS_MESSAGE = "ADD OR EDIT SUCCESS";
    private static final String DELETE_SUCCESS_MESSAGE = "DELETE SUCCESS";



    public static CommonResult genSuccessfulResult(){
        return new CommonResult()
                .setCode(ResultCode.CODE_REQUEST_OK.getCode())
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static CommonResult genSuccessfulResult(Object data){
        return new CommonResult()
                .setCode(ResultCode.CODE_REQUEST_OK.getCode())
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }


    public static CommonResult genSuccessfulResult(String message,Object data){
        return new CommonResult()
                .setCode(ResultCode.CODE_REQUEST_OK.getCode())
                .setMessage(message)
                .setData(data);
    }
    public static CommonResult genErrorResult(Object data){
        return new CommonResult()
                .setCode(ResultCode.CODE_SERVICE_ERROR.getCode())
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static CommonResult genSuccessMsgResult(String message) {
        return new CommonResult()
                .setCode(ResultCode.CODE_DELETE_SUCCESS.getCode())
                .setMessage(message);
    }

    public static CommonResult genFailResult(String message) {
        return new CommonResult()
                .setCode(ResultCode.CODE_REQUEST_ERROR.getCode())
                .setMessage(message);
    }
    public static CommonResult genFailResult() {
        return new CommonResult()
                .setCode(ResultCode.CODE_REQUEST_ERROR.getCode());
    }


    public static CommonResult genResult(String message,Object data) {
        return new CommonResult()
                .setCode(ResultCode.CODE_REQUEST_OK.getCode())
                .setMessage(message)
                .setData(data);
    }

    public static CommonResult genResult(ResultCode resultCode,String message,Object data) {
        return new CommonResult()
                .setCode(resultCode.getCode())
                .setMessage(message)
                .setData(data);
    }


    public static CommonResult genEditSuccessfulResult(Object data) {
        return new CommonResult()
                .setCode(ResultCode.CODE_EDIT_SUCCESS.getCode())
                .setMessage(EDIT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static CommonResult genDeleteSuccessfulResult(Object data) {
        return new CommonResult()
                .setCode(ResultCode.CODE_DELETE_SUCCESS.getCode())
                .setMessage(DELETE_SUCCESS_MESSAGE)
                .setData(data);
    }

}
