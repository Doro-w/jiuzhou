package com.jiuzhou.server.service.impl;

import com.jiuzhou.server.entity.ProvinceSales;
import com.jiuzhou.server.mapper.ProvinceMapper;
import com.jiuzhou.server.mapper.ProvinceSalesMapper;
import com.jiuzhou.server.service.ProvinceSalesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ProvinceSalesMapper provinceSalesMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public Integer querySalesByProvince(String pname){
        // 根据省份名获取省份id
        Integer provinceId = provinceMapper.queryIdByProvinceName(pname);
        return provinceSalesMapper.querySalesByProvince(provinceId);
    }
}
