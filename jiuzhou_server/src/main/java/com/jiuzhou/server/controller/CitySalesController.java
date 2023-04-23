package com.jiuzhou.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiuzhou.server.service.CitySalesService;
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
@RequestMapping("/citySales")
@CrossOrigin
public class CitySalesController {

    @Autowired
    CitySalesService service;

    /** 查询城市销量的方法
     * @param cname 城市名
     * @return citySales 城市销售额
     */
    @GetMapping("queryCitySales")
    public HashMap<String, Object> queryCitySales(@RequestParam(value = "city")String cname){
        int citySales = service.queryCitySales(cname);
        if(citySales >= 0){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
                put("result", citySales);  //嵌套json
            }};
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

    /** 查询某一省份所有城市销量的方法
     * @param pname 省份名
     * @return citySales
     */
    @GetMapping("queryCitySalesByProvince")
    public HashMap<String, Object> queryCitySalesByProvince(@RequestParam(value = "province")String pname){
        List<JSONObject> citySales = service.queryAllCitySalesByProvince(pname);
        if(citySales != null){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
                put("result", citySales);  //嵌套json
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

