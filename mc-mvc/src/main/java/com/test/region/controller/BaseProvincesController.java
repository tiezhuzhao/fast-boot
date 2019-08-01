package com.test.region.controller;


import com.test.common.config.Aspect.SystemLog;
import com.test.common.config.response.Result;
import com.test.common.config.response.R;
import com.test.region.service.IBaseProvincesService;
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

    private static final Logger logger = LoggerFactory.getLogger(BaseProvincesController.class);

    @Autowired
    private IBaseProvincesService provincesService;

    @ApiOperation("查询省份信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "countryId",required = true,value = "地区")
    })
    @SystemLog(description = "查询省份信息")
    @GetMapping(value = "/getProvincesByCountryId")
    public Result getProvincesByCountryId(String countryId) throws Exception {
        try {
            return R.success(provincesService.getProvincesByCountryId(countryId));
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return R.error(e.getMessage());
        }

    }
}
