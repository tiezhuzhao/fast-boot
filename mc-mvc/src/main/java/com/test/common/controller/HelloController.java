package com.test.common.controller;

import com.test.common.config.response.Result;
import com.test.common.config.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: mc
 * Package: com.test.mc.controller
 * Description: ...
 * <p>
 * @author Mars
 * Data: 2018/5/3 下午4:16
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping(value = "/login")
    public Result login() throws Exception {
        return R.success("登录成功");
    }
}
