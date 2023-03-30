package com.jiuzhou.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.sf.jsqlparser.statement.create.table.Index;

/**
 * <p>
 * 
 * </p>
 *
 * @author doro
 * @since 2023-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CitySales implements Serializable {

  private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

  private Integer cityIndex;

  private Integer provinceId;

  private Integer amount;

}
