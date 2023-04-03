package com.jiuzhou.server.mapper;

import com.jiuzhou.server.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author doro
 * @since 2023-03-20
 */
@Mapper
@Repository
public interface CityMapper extends BaseMapper<City> {
    @Select("select * from city where name = #{cname}")
    City queryIndexByName(String cname);

    @Select("select count(*) from city where province_id = ${privinceId}")
    Integer countByProvinceId(Integer provinceId);

    @Select("select name from city where province_id = ${provinceId} and city_index = ${cityIndex}")
    String queryNameById(Integer provinceId, Integer cityIndex);
}
