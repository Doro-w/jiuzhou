package com.jiuzhou.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class DeviceModel implements Serializable {

    private String name;

    private String type;

    private String area;

    private Integer state;

    private String alarm;


}