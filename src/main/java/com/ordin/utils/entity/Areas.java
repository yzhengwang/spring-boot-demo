package com.ordin.utils.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 地区信息
 * </p>
 *
 * @author yzhengwang
 * @since 2018-11-30
 */
@Data
@TableName("syd_areas")
public class Areas implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)

    /**
     * id
     */
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 省市地区名称
     */
    private String areaName;

    /**
     * 省市地区拼音
     */
    private String pyName;

    /**
     * 首字母
     */
    private String pyFirst;

    /**
     * 邮政编码
     */
    private Integer zipcode;

    /**
     * 类型(0:国家;1:省份;2:城市;3:地区)
     */
    private Boolean areaType;

    /**
     * 直辖市的标记(0:否;1:是)
     */
    private Boolean special;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 地区
     */
    private String areaRegion;


}
