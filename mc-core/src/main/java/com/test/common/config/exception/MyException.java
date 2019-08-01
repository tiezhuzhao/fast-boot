package com.test.common.config.exception;

import com.test.common.config.response.Code;

/**
 * Project: mc
 * Package: com.test.common.config.exception
 * Description: ...
 * <p>
 * @author Mars
 * Data: 2018/5/3 下午4:16
 */
public class MyException extends RuntimeException {

    private Code code;

    private Object obj;

    public MyException(Code code, String msg, Object obj) {
        super(msg);
        this.code = code;
        this.obj = obj;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
