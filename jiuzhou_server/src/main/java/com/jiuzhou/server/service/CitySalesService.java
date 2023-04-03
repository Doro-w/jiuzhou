package com.jiuzhou.server.service;

import com.jiuzhou.server.entity.CitySales;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author doro
 * @since 2023-03-06
 */
public interface CitySalesService extends IService<CitySales> {
    public Integer queryCitySales(String city);
    public List<HashMap<String, Object>> queryCitySalesByProvince(String pname);
}
