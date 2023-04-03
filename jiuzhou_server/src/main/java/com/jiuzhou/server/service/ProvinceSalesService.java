package com.jiuzhou.server.service;

import com.jiuzhou.server.entity.ProvinceSales;
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
public interface ProvinceSalesService extends IService<ProvinceSales> {
    public Integer queryProvinceSales(String pname);
    public  List<HashMap<String, Object>> queryAllProvinceSales();
}
