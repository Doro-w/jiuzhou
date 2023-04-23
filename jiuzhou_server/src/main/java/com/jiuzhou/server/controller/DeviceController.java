package com.jiuzhou.server.controller;

import com.github.pagehelper.PageInfo;
import com.jiuzhou.server.entity.Device;
import com.jiuzhou.server.entity.DeviceModel;
import com.jiuzhou.server.service.DeviceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author doro
 * @since 2023-03-06
 */
@RestController
@RequestMapping("/device")
@CrossOrigin
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    /** 分页查询所有设备数据的方法
     * @param page 页码
     * @param pageSize 每页数
     * @return PageInfo<Device>
     */
    @GetMapping("/queryAllDeviceByPage")
    public HashMap<String, Object> queryAllDeviceByPage(@RequestParam(value = "page")Integer page, @RequestParam(value = "pageSize")Integer pageSize){
        PageInfo<DeviceModel> devices = deviceService.getAllDeviceByPage(page, pageSize);
        if(devices != null){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
                put("result", devices.getList());  //嵌套json
            }};
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

    /** 不分页查询所有设备数据的方法
     */
    @GetMapping("/queryAllDevice")
    public HashMap<String, Object> queryAllDevice(){
        List<DeviceModel> devices = deviceService.getAllDevice();
        if(devices != null){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
                put("result", devices);  //嵌套json
            }};
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

    /** 条件查询设备数据的方法
     */
    @GetMapping("/queryDevice")
    public HashMap<String, Object> queryDevice(@Param(value = "type")String type, @Param(value = "area")String area,
                                               @Param(value = "state")Integer state, @Param(value = "alarm")String alarm){
        List<DeviceModel> devices = deviceService.queryDevice(type, area, state, alarm);
        if(devices != null){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
                put("result", devices);  //嵌套json
            }};
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }
}

