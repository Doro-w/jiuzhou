package com.jiuzhou.server.service.impl;

import com.jiuzhou.server.entity.City;
import com.jiuzhou.server.entity.CitySales;
import com.jiuzhou.server.mapper.CityMapper;
import com.jiuzhou.server.mapper.CitySalesMapper;
import com.jiuzhou.server.service.CitySalesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author doro
 * @since 2023-03-06
 */
@Service("CitySales")
public class CitySalesServiceImpl extends ServiceImpl<CitySalesMapper, CitySales> implements CitySalesService {
    @Autowired
    private CitySalesMapper citySalesMapper;

    @Autowired
    private CityMapper cityMapper;

    @Override
    public Integer querySalesByCity(String cname){
        // 根据城市名获取province_id, city_index
        City city = cityMapper.queryIndexByName(cname);
        Integer amount = citySalesMapper.querySalesByCity(city.getCityIndex(), city.getProvinceId());
        return amount;
    }
}
