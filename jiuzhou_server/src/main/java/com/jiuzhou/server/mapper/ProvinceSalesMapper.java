package com.jiuzhou.server.mapper;

import com.jiuzhou.server.entity.ProvinceSales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiuzhou.server.entity.ProvinceSalesModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author doro
 * @since 2023-03-06
 */
@Mapper
public interface ProvinceSalesMapper extends BaseMapper<ProvinceSales> {
    List<ProvinceSalesModel> queryAllProvinceSales();

    @Select("select amount from province_sales where province_id = ${provinceId}")
    Integer queryProvinceSales(Integer provinceId);

    @Insert("insert into province_sales(province_id, amount) values (${provinceId}, ${amount});")
    int insertProvinceSales(Integer provinceId, Integer amount);
}
