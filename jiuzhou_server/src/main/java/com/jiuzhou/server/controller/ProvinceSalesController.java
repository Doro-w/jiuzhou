package com.jiuzhou.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiuzhou.server.service.ProvinceSalesService;
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
@RequestMapping("/provinceSales")
@CrossOrigin
public class ProvinceSalesController {
    @Autowired
    ProvinceSalesService service;

    /** 查询省份销量的方法
     * @param pname 省份名
     * @return provinceSales 省份销售额
     */
    @GetMapping("/queryProvinceSales")
    public HashMap<String, Object> queryProvinceSales(@RequestParam(value = "province")String pname){
        Integer provinceSales = service.queryProvinceSales(pname);
        if(provinceSales != null){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
                put("result", provinceSales);  //嵌套json
            }};
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

    /** 查询所有省份销量的方法
     * @return provinceSales
     */
    @GetMapping("/queryAllProvinceSales")
    public HashMap<String, Object> queryAllProvinceSales(){
        List<JSONObject> provinceSales = service.queryAllProvinceSales();
        if(provinceSales != null){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
                put("result", provinceSales);  //嵌套json
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

