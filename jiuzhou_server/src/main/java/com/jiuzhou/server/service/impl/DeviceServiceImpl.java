package com.jiuzhou.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiuzhou.server.entity.Device;
import com.jiuzhou.server.mapper.DeviceMapper;
import com.jiuzhou.server.service.DeviceService;
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
@Service("DeviceService")
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    /** 分页查询所有设备信息的方法
     * @param page 页码
     * @param pageSize 每页数
     * @return PageInfo<Device>
     */
    @Override
    public PageInfo<Device> getAllDeviceByPage(Integer page, Integer pageSize){
        // PageHepler框架实现分页最核心的代码就是在运行要分页的查询语句之前
        // 通过框架给定的方法设置要分页查询的要求(第几页,每页多少条)
        // 参数page和SpringData框架的设计不同,page为1就是第一页,page为2就是第二页
        PageHelper.startPage(page,pageSize);
        // 当上面设置完分页要求后,下面紧随的下一次查询,
        // 就会自动在sql语句末尾添加limit关键字,limit后面的值就是按page,pageSize得出的
        List<Device> list= deviceMapper.queryAllDevice();
        // list并不是全部的订单的集合,而是按上面分页条件查询出的分页数据
        // 在返回时不直接返回list对象,而是返回PageHelper框架提供的PageInfo类型对象
        // 这个对象可以保存list集合的同时,还能自动计算分页信息
        return new PageInfo<>(list);
    }

    @Override
    public List<Device> getAllDevice(){
        return deviceMapper.queryAllDevice();
    }
}
