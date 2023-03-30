package com.jiuzhou.server.generator;

import com.jiuzhou.server.mapper.CityMapper;
import com.jiuzhou.server.mapper.CitySalesMapper;
import com.jiuzhou.server.mapper.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

/**
 * 根据每个entity类中的字段类型创建随机数据
 * @author doro
 * @since 2023-03-23
 */
@Component
public class CitySalesGenerator {
    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CitySalesMapper citySalesMapper;

    public void generate(){
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(10000L);

        int pCount = 0, cCount = 0;

        pCount = provinceMapper.countProvince();
        if (pCount > 0) {
            for(int i = 1; i <= pCount; i++){
                cCount = cityMapper.countByProvinceId(i);
                if(cCount > 0){
                    for(int j = 1; j <= cCount; j++){
                        int randomNum = secureRandom.nextInt(150);
                        citySalesMapper.insertCitySales(j, i, randomNum);
                    }
                }
            }
        }
    }
}
