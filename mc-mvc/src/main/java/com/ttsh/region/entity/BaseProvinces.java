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
public class BaseProvinces implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("provinceId")
    private Integer provinceId;

    private String province;

    private Long countryId;


}
