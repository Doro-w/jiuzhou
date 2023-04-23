package com.jiuzhou.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiuzhou.server.entity.ProvinceSales;
import com.jiuzhou.server.entity.ProvinceSalesModel;
import com.jiuzhou.server.mapper.ProvinceMapper;
import com.jiuzhou.server.mapper.ProvinceSalesMapper;
import com.jiuzhou.server.service.ProvinceSalesService;
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
@Service("ProvinceSales")
public class ProvinceSalesServiceImpl extends ServiceImpl<ProvinceSalesMapper, ProvinceSales> implements ProvinceSalesService {
    @Autowired
    ProvinceSalesMapper provinceSalesMapper;

    @Autowired
    ProvinceMapper provinceMapper;

    @Override
    public Integer queryProvinceSales(String pname){
        // 根据省份名获取省份id
        Integer pId = provinceMapper.queryIdByProvinceName(pname);
        return provinceSalesMapper.queryProvinceSales(pId);
    }

    @Override
    public  List<JSONObject> queryAllProvinceSales(){
        List<JSONObject> result = new ArrayList<>();
        List<ProvinceSalesModel> S = provinceSalesMapper.queryAllProvinceSales();
        for (ProvinceSalesModel s : S) {
            String jsonStr = JSON.toJSONString(s);   //将java对象转换为json字符串
            JSONObject map = JSON.parseObject(jsonStr);  //将json字符串转换为json对象
            result.add(map);
        }
        return result;
    }
}
