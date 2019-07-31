package com.test.region.service;

import com.test.region.entity.BaseProvinces;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaozhe
 * @since 2019-07-31
 */
public interface IBaseProvincesService extends IService<BaseProvinces> {

    List<BaseProvinces> getProvincesByCountryId(String countryId);

}
