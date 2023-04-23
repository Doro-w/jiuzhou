package com.jiuzhou.server.service;

import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiuzhou.server.entity.DeviceModel;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author doro
 * @since 2023-03-06
 */
public interface DeviceService extends IService<DeviceModel> {
    public PageInfo<DeviceModel> getAllDeviceByPage(Integer page, Integer pageSize);
    public List<DeviceModel> getAllDevice();
    public List<DeviceModel> queryDevice(String type, String area, Integer state, String alarm);
}
