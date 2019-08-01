package com.test.common.config.exception;

import cn.hutool.core.exceptions.ValidateException;
import com.test.common.config.response.Result;
import com.test.common.config.response.R;
import com.test.common.config.response.Code;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Project: mc
 * Package: com.test.common.config.exception
 * Description: ...
 * <p>
 * @author Mars
 * Data: 2018/5/3 下午4:16
 */
@ControllerAdvice
public class MyExceptionUtil {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof MyException) {
            MyException myexception = (MyException) e;
            return R.error(myexception.getCode(), myexception.getMessage(), myexception.getObj());
        } else if (e instanceof ValidateException) {
            ValidateException ve = (ValidateException) e;
            String errors = ve.getMessage();
            return R.error(Code.PARAMS_VALID_FAIL, errors, null);
        } else if (e instanceof NoHandlerFoundException) {
            return R.error(Code.NOT_FOUND, e.getMessage(), null);
        } else {
            Logger logger = LoggerFactory.getLogger(MyException.class);
            logger.error("[system excepiton] {}", e);
            return R.error(Code.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
