package com.jiuzhou.server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class CitySalesModel implements Serializable {

    private String name;

    private Integer value;
}
