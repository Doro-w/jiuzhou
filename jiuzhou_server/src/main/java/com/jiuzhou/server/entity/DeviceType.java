package com.jiuzhou.server.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author doro
 * @since 2023-04-23
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class DeviceType implements Serializable {

    private static final long serialVersionUID=1L;

      private Integer id;

    private String name;


}
