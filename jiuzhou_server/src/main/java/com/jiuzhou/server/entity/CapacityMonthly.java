package com.jiuzhou.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author doro
 * @since 2023-03-21
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class CapacityMonthly implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private LocalDate time;

    private Integer amount;


}
