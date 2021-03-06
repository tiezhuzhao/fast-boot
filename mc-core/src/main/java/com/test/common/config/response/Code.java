package com.test.common.config.response;

/**
 * Project: mc
 * Package: com.test.common.config.response
 * Description: ...
 *
 * @author: Mars
 * Data: 2018/5/8 下午5:41
 */
public enum Code {

    //成功
    SUCCESS(1),
    //失败
    FAIL(0),
    //未认证（签名错误）
    UNAUTHORIZED(-1),
    //请求参数校验错误
    PARAMS_VALID_FAIL(400),
    //接口不存在
    NOT_FOUND(404),
    //服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    private final Integer code;

    Code(Integer code) {
        this.code = code;
    }

    public Integer code() {
        return code;
    }
}
