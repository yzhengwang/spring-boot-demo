package com.ordin.utils.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品表 V2 新版商城
 * </p>
 *
 * @author yzhengwang
 * @since 2018-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("syd_shop_goods")
public class ShopGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品公共表id
     */
    private Integer commonid;

    /**
     * 商品名称（+规格名称）
     */
    private String name;

    /**
     * 商品广告词
     */
    private String jingle;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 商品分类id
     */
    private Integer cateId;

    /**
     * 一级分类id
     */
    private Integer cateId1;

    /**
     * 二级分类id
     */
    private Integer cateId2;

    /**
     * 三级分类id
     */
    private Integer cateId3;

    /**
     * 品牌id
     */
    private Integer brandId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品促销价格
     */
    private BigDecimal promotionPrice;

    /**
     * 促销类型 0无促销，1团购，2限时折扣
     */
    private Integer promotionType;

    /**
     * 市场价
     */
    private BigDecimal marketprice;

    /**
     * 商品库存
     */
    private Integer storage;

    /**
     * 库存报警值
     */
    private Integer storageAlarm;

    /**
     * 商家编号
     */
    private String serial;

    /**
     * 商品点击数量
     */
    private Integer click;

    /**
     * 销售数量
     */
    private Integer salenum;

    /**
     * 收藏数量
     */
    private Integer collect;

    /**
     * 商品规格序列化
     */
    private String spec;

    /**
     * 商品主图
     */
    private String thumb;

    /**
     * 商品状态 0下架，1正常，10违规（禁售）
     */
    private Integer state;

    /**
     * 商品审核 1通过，0未通过，10审核中
     */
    private Integer verify;

    /**
     * 商品添加时间
     */
    private Integer addtime;

    /**
     * 商品编辑时间
     */
    private Integer edittime;

    /**
     * 一级地区id
     */
    private Integer areaid1;

    /**
     * 二级地区id
     */
    private Integer areaid2;

    /**
     * 颜色规格id
     */
    private Integer colorId;

    /**
     * 售卖区域id
     */
    private Integer transportId;

    /**
     * 运费 0为免运费
     */
    private BigDecimal freight;

    /**
     * 是否开具增值税发票 1是，0否
     */
    private Integer vat;

    /**
     * 商品推荐 1是，0否 默认0
     */
    private Integer commend;

    /**
     * 店铺分类id 首尾用,隔开
     */
    private String stcids;

    /**
     * 好评星级
     */
    private Integer evaluationGoodStar;

    /**
     * 评价数
     */
    private Integer evaluationCount;

    /**
     * 是否为虚拟商品 1是，0否
     */
    private Integer isVirtual;

    /**
     * 虚拟商品有效期
     */
    private Integer virtualIndate;

    /**
     * 虚拟商品购买上限
     */
    private Integer virtualLimit;

    /**
     * 是否允许过期退款， 1是，0否
     */
    private Integer virtualInvalidRefund;

    /**
     * 是否为F码商品 1是，0否
     */
    private Integer isFcode;

    /**
     * 是否是预约商品 1是，0否
     */
    private Integer isAppoint;

    /**
     * 是否是预售商品 1是，0否
     */
    private Integer isPresell;

    /**
     * 是否拥有赠品
     */
    private Integer haveGift;

    /**
     * 是否为平台自营
     */
    private Integer isOwnShop;


}
