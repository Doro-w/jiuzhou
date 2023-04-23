package com.jiuzhou.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2023-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Device implements Serializable {

  private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

  private String name;

  private Integer typeId;

  private String area;

  private Integer state;

  private Integer alarmId;


}
