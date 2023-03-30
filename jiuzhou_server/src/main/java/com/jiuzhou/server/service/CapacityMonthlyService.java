package com.jiuzhou.server.service;

import com.jiuzhou.server.entity.CapacityMonthly;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author doro
 * @since 2023-03-21
 */
public interface CapacityMonthlyService extends IService<CapacityMonthly> {
    public List<CapacityMonthly> query12month(String date);
}
