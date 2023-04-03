package com.jiuzhou.server.mapper;

import com.jiuzhou.server.entity.Province;
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
public interface ProvinceMapper extends BaseMapper<Province> {
    @Select("select id from province where name = #{province}")
    Integer queryIdByProvinceName(String province);

    @Select("select count(*) from province")
    Integer countProvince();

    @Select("select name from province where id = ${id}")
    String queryNameByProvinceId(Integer id);
}
