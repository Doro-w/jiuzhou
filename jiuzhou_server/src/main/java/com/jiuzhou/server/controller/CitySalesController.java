package com.jiuzhou.server.controller;

import com.jiuzhou.server.service.CitySalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
    private CitySalesService service;

    /** 查询城市销量的方法
     * @param cname 城市名
     * @return citySales 城市销售额
     */
    @GetMapping("querySalesByCity")
    public HashMap<String, Object> querySalesByCity(@RequestParam(value = "city")String cname){
        Integer citySales = service.querySalesByCity(cname);
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

