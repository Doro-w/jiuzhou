package com.jiuzhou.server.service;

import com.alibaba.fastjson.JSONObject;
import com.jiuzhou.server.entity.CitySales;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiuzhou.server.entity.CitySalesModel;

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
    public int queryCitySales(String city);
    public List<JSONObject> queryAllCitySalesByProvince(String pname);
}
