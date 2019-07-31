package com.ttsh.region.controller;


import com.ttsh.mc.config.Aspect.SystemLog;
import com.ttsh.mc.config.response.ResponseResult;
import com.ttsh.mc.config.response.ResponseResultUtil;
import com.ttsh.mc.controller.TestController;
import com.ttsh.region.service.IBaseProvincesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaozhe
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/region/provinces")
@Api(value = "region/provinces", tags = {"地区-省份"}, description = "基础数据")
public class BaseProvincesController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private IBaseProvincesService provincesService;

    @ApiOperation("查询省份信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "countryId",required = true,value = "地区")
    })
    @SystemLog(description = "测试AOP打印日志")
    @GetMapping(value = "/getProvincesByCountryId")
    public ResponseResult getProvincesByCountryId(String countryId) throws Exception {
        try {
            return ResponseResultUtil.success(provincesService.getProvincesByCountryId(countryId));
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return ResponseResultUtil.error(e.getMessage());
        }

    }
}
