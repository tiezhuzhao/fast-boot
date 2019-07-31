package com.ttsh.region.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaozhe
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseCities implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市编码
     */
    @TableField("cityId")
    private Integer cityId;

    private String city;

    @TableField("provinceId")
    private Integer provinceId;


}
