package com.test.common.config.response;

/**
 * Project: mc
 * Package: com.test.common.config.response
 * Description: ...
 * <p>
 * @author Mars
 * Data: 2018/5/3 下午4:16
 */
public class R {

    private static final String DEFAULT_SUCCESS_MESSAGE = "success";

    public static Result success(Object obj) {
        Result result = new Result();
        result.setCode(Code.SUCCESS);
        result.setMsg(DEFAULT_SUCCESS_MESSAGE);
        result.setData(obj);

        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Code code, String msg, Object obj) {
        Result resutl = new Result();
        resutl.setCode(code);
        resutl.setMsg(msg);
        resutl.setData(obj);

        return resutl;
    }

    public static Result error(String msg) {
        return error(Code.FAIL, msg, null);
    }

    public static Result error(Code code, String msg) {
        return error(code, msg, null);
    }
}
