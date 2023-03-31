package com.jiuzhou.server.generator;

import com.jiuzhou.server.mapper.CitySalesMapper;
import com.jiuzhou.server.mapper.ProvinceMapper;
import com.jiuzhou.server.mapper.ProvinceSalesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 将citySales中的城市销量统计成为省份销量
 * @author doro
 * @since 2023-03-23
 */
@Component
public class ProvinceSalesGenerator {
    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CitySalesMapper citySalesMapper;

    @Autowired
    private ProvinceSalesMapper provinceSalesMapper;

    public void generate() {
        int pCount = 0;

        pCount = provinceMapper.countProvince();
        if(pCount > 0){
            for(int i = 1; i <= pCount; i++){
                int total = citySalesMapper.totalSalesOfProvince(i);
                provinceSalesMapper.insertProvinceSales(i, total);
            }
        }
    }
}
