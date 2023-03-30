package com.jiuzhou.server.controller;

import com.jiuzhou.server.entity.CapacityMonthly;
import com.jiuzhou.server.service.CapacityMonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author doro
 * @since 2023-03-21
 */
@RestController
@RequestMapping("/capacityMonthly")
@CrossOrigin
public class CapacityMonthlyController {

    @Autowired
    CapacityMonthlyService service;

    /** 查询最近12个月的月度处理量方法
     * @return HashMap<String, Object>
     * msg 查询数据不为空，则为success
     * code 查询数据少于12个月，则返回码为2
     * list 按照时间降序排列，时间最近的在列表首位
     */
    @GetMapping("/queryRecent12month")
    public HashMap<String, Object> queryRecent12month(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(calendar.getTime());
        List<CapacityMonthly> list = service.query12month(date);
        if(list.size() > 0) {
            if (list.size() < 12) {
                return new HashMap<String, Object>() {{
                    put("msg", "success!");
                    put("code", "2");
                    put("result", list);  //嵌套json
                }};
            } else {
                return new HashMap<String, Object>() {{
                    put("msg", "success!");
                    put("code", "1");
                    put("result", list);  //嵌套json
                }};
            }
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

    /** 查询指定日期的前12个月的月度处理量方法
     * @param year 年
     * @param month 月
     * @return HashMap<String, Object>
     * msg 查询数据不为空，则为success
     * code 查询数据为空，则code为0；正好12个月，则code为1；少于12个月，则code为2
     * list 按照时间降序排列，时间最近的在列表首位
     */
    @GetMapping("/query12monthfromDate")
    public HashMap<String, Object> query12monthfromDate(int year, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(calendar.getTime());
        List<CapacityMonthly> list = service.query12month(date);
        if(list.size() > 0) {
            if (list.size() < 12) {
                return new HashMap<String, Object>() {{
                    put("msg", "success!");
                    put("code", "2");
                    put("result", list);  //嵌套json
                }};
            } else {
                return new HashMap<String, Object>() {{
                    put("msg", "success!");
                    put("code", "1");
                    put("result", list);  //嵌套json
                }};
            }
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

}

