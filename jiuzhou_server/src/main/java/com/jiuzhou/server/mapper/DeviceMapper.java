package com.jiuzhou.server.mapper;

import com.jiuzhou.server.entity.Device;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 *
 * </p>
 * @author doro
 * @since 2023-03-06
 */
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
    @Select("select * from device")
    List<Device> queryAllDevice();
}
