package com.jiuzhou.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiuzhou.server.entity.City;
import com.jiuzhou.server.entity.CitySales;
import com.jiuzhou.server.entity.CitySalesModel;
import com.jiuzhou.server.entity.ProvinceSalesModel;
import com.jiuzhou.server.mapper.CityMapper;
import com.jiuzhou.server.mapper.CitySalesMapper;
import com.jiuzhou.server.mapper.ProvinceMapper;
import com.jiuzhou.server.mapper.ProvinceSalesMapper;
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
    ProvinceSalesMapper provinceSalesMapper;

    @Autowired
    CitySalesMapper citySalesMapper;

    @Override
    public int queryCitySales(String cname){
        // 根据城市名获取province_id, city_index
        City city = cityMapper.queryIndexByName(cname);
        if(city != null){
            return citySalesMapper.querySalesByCity(city.getCityIndex(), city.getProvinceId());
        }
        else {
            return -1;
        }
    }

    @Override
    public List<JSONObject> queryAllCitySalesByProvince(String pname){
        List<JSONObject> result = new ArrayList<>();
        List<CitySalesModel> S = citySalesMapper.queryAllCitySalesByProvince(pname);
        for (CitySalesModel s : S) {
            String jsonStr = JSON.toJSONString(s);   //将java对象转换为json字符串
            JSONObject map = JSON.parseObject(jsonStr);  //将json字符串转换为json对象
            result.add(map);
        }
        // 台湾省由于前端地图原因，增加一个额外数据
        HashMap<String, Object> temp = new HashMap<>();
        Integer twId = provinceMapper.queryIdByProvinceName("台湾");
        temp.put("name", "台湾省");
        temp.put("value", provinceSalesMapper.queryProvinceSales(twId));
        String jsonStr = JSON.toJSONString(temp);
        JSONObject map = JSON.parseObject(jsonStr);
        result.add(map);

        return result;
    }
}
