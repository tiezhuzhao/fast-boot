package com.ttsh.region.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttsh.region.entity.BaseProvinces;
import com.ttsh.region.mapper.BaseProvincesMapper;
import com.ttsh.region.service.IBaseProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaozhe
 * @since 2019-07-31
 */
@Service
@CacheConfig(cacheNames = "base_provinces")
public class BaseProvincesServiceImpl extends ServiceImpl<BaseProvincesMapper, BaseProvinces> implements IBaseProvincesService {

    @Autowired
    private BaseProvincesMapper provincesMapper;

    @Override
    public List<BaseProvinces> getProvincesByCountryId(String countryId) {
        QueryWrapper<BaseProvinces> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(BaseProvinces::getCountryId, countryId);
        /* 方案二 查询省份列表 start */
//        QueryWrapper<BaseProvinces> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda()
//                .and(obj ->
//                        obj.eq(BaseProvinces::getCountryId, countryId);
        /* 方案二 查询省份列表 end */
        List<BaseProvinces> list = list(queryWrapper);
//        for (BaseProvinces student : BaseProvinces)
//            Console.info(new Gson().toJson(student));
        return list;
    }
}
