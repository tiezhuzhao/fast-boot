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
public class BaseCountry implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 中国 惯用名
     */
    @TableField("countryName")
    private String countryName;

    /**
     * 国家或地区（ISO 英文用名）
     */
    @TableField("countryEnName")
    private String countryEnName;

    /**
     * 二位字母
     */
    private String twoBitLetters;

    /**
     * 三位 字母
     */
    private String threeBitLetters;

    /**
     * 数字
     */
    @TableField("countryNumber")
    private String countryNumber;

    /**
     * ISO 3166-2相应代码
     */
    @TableField("countryIos")
    private String countryIos;

    /**
     * 备注
     */
    @TableField("countryRemarks")
    private String countryRemarks;

    /**
     * 首都
     */
    private String companyCapital;


}
