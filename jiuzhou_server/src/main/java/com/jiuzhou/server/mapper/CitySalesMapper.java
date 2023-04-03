package com.jiuzhou.server.mapper;

import com.jiuzhou.server.entity.CitySales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.annotation.ManagedBean;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author doro
 * @since 2023-03-06
 */
@Mapper
public interface CitySalesMapper extends BaseMapper<CitySales> {
    @Select("select amount from city_sales where city_index = ${cityIndex} and province_id = ${provinceId}")
    int querySalesByCity(Integer cityIndex, Integer provinceId);

    @Insert("insert into city_sales(city_index, province_id, amount) values (#{cityIndex}, #{provinceId}, #{amount});")
    int insertCitySales(Integer cityIndex, Integer provinceId, Integer amount);

    @Select("select sum(amount) from city_sales where province_id = #{provinceId}")
    int totalSalesOfProvince(Integer provinceId);
}
