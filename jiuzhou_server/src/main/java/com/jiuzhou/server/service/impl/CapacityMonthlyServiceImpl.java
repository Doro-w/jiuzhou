package com.jiuzhou.server.service.impl;

import com.jiuzhou.server.entity.CapacityMonthly;
import com.jiuzhou.server.mapper.CapacityMonthlyMapper;
import com.jiuzhou.server.service.CapacityMonthlyService;
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
 * @since 2023-03-21
 */
@Service("CapacityMonthlyService")
public class CapacityMonthlyServiceImpl extends ServiceImpl<CapacityMonthlyMapper, CapacityMonthly> implements CapacityMonthlyService {
    @Autowired
    private CapacityMonthlyMapper mapper;

    @Override
    public List<CapacityMonthly> query12month(String date){
        return mapper.query12month(date);
    }
}
