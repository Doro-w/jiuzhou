package com.jiuzhou.server.service.impl;

import com.jiuzhou.server.entity.ProvinceSales;
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
    public  List<HashMap<String, Object>> queryAllProvinceSales(){
        List<HashMap<String, Object>> result = new ArrayList<>();
        int count = provinceMapper.countProvince();
        for(int i = 1; i <= count; i++){
            HashMap<String, Object> temp = new HashMap<>();
            temp.put("name", provinceMapper.queryNameByProvinceId(i));
            temp.put("value", provinceSalesMapper.queryProvinceSales(i));
            result.add(temp);
        }
        return result;
    }
}
