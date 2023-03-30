package com.jiuzhou.server.mapper;

import com.jiuzhou.server.entity.CapacityMonthly;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author doro
 * @since 2023-03-21
 */
@Mapper
public interface CapacityMonthlyMapper extends BaseMapper<CapacityMonthly> {
    @Select("select * from capacity_monthly where TIMESTAMPDIFF(MONTH, time, '${date}') >= 0 and TIMESTAMPDIFF(MONTH, time, '${date}') <= 12 ORDER BY time DESC;")
    public List<CapacityMonthly> query12month(String date);
}
