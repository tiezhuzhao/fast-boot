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
public class BaseAreas implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区县编码
     */
    @TableField("areaId")
    private Integer areaId;

    /**
     * 区县名称
     */
    private String area;

    /**
     * 所属城市编码
     */
    @TableField("cityId")
    private Integer cityId;


}
