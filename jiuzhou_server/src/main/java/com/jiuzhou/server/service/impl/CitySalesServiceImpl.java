package com.jiuzhou.server.service.impl;

import com.jiuzhou.server.entity.City;
import com.jiuzhou.server.entity.CitySales;
import com.jiuzhou.server.mapper.CityMapper;
import com.jiuzhou.server.mapper.CitySalesMapper;
import com.jiuzhou.server.mapper.ProvinceMapper;
import com.jiuzhou.server.service.CitySalesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    ProvinceMapper provinceMapper;

    @Autowired
    CityMapper cityMapper;

    @Autowired
    CitySalesMapper citySalesMapper;

    @Override
    public Integer queryCitySales(String cname){
        // 根据城市名获取province_id, city_index
        City city = cityMapper.queryIndexByName(cname);
        Integer amount = citySalesMapper.querySalesByCity(city.getCityIndex(), city.getProvinceId());
        return amount;
    }

    @Override
    public List<HashMap<String, Object>> queryCitySalesByProvince(String pname){
        List<HashMap<String, Object>> result = new ArrayList<>();
        // 根据省份名获取省份id
        Integer pId = provinceMapper.queryIdByProvinceName(pname);
        Integer count = cityMapper.countByProvinceId(pId);
        for(int i = 1; i <= count; i++){
            HashMap<String, Object> temp = new HashMap<>();
            temp.put("name", cityMapper.queryNameById(pId, i));
            temp.put("value", citySalesMapper.querySalesByCity(i, pId));
            result.add(temp);
        }
        return result;
    }
}
