package com.jiuzhou.server.service;

import com.github.pagehelper.PageInfo;
import com.jiuzhou.server.entity.Device;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author doro
 * @since 2023-03-06
 */
public interface DeviceService extends IService<Device> {
    public PageInfo<Device> getAllDeviceByPage(Integer page, Integer pageSize);
    public List<Device> getAllDevice();
}
