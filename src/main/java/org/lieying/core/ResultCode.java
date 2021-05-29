package org.lieying.core;

import com.alibaba.fastjson.JSON;

/**
 * 返回值结果枚举
 */
/*
*
* 1**	信息，服务器收到请求，需要请求者继续执行操作
  2**	成功，操作被成功接收并处理
  3**	重定向，需要进一步的操作以完成请求
  4**	客户端错误，请求包含语法错误或无法完成请求
  5**	服务器错误，服务器在处理请求的过程中发生了错误
* */
public enum ResultCode {
    /**
     * 请求已成功，请求所希望的响应头或数据体将随此响应返回。出现此状态码是表示正常状态。
     */
    CODE_REQUEST_OK(200),
    /**
     * 用户新建或修改数据成功
     */
    CODE_EDIT_SUCCESS(201),
    /**
     * 用户删除数据成功
     */
    CODE_DELETE_SUCCESS(204),
    /**
     * 用户请求失败
     */
    CODE_REQUEST_ERROR(400),
    /**
     * 未经验证的用户，常见于未登录（令牌、用户名、密码错误）
     */
    CODE_UNAUTHORIZED(401),
    /**
     * 无权限
     */
    CODE_FORBIDDEN(403),
    /**
     * 用户请求的数据不存在
     */
    CODE_NOT_FOUND(404),
    /**
     * 服务器发生错误
     */
    CODE_SERVICE_ERROR(500),
    /**
     * 参数异常
     */
    CODE_PARAMETER_ERROR(501),

    /**
     * 需执行处理
     */
    DATA_ERROR(5000);;

    private int code;

    ResultCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
