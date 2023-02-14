package com.wallet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户消费详情表
 */
@ApiModel(description="用户消费详情表")
@Data
@TableName("user_wallet_record")
public class UserWalletRecord implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="id")
    private String id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="用户id")
    private String userId;

    /**
     * 交易名称
     */
    @TableField(value = "trade_name")
    @ApiModelProperty(value="交易名称")
    private String tradeName;

    /**
     * 交易金额
     */
    @TableField(value = "trade_money")
    @ApiModelProperty(value="交易金额")
    private BigDecimal tradeMoney;

    /**
     * 交易类型（1支出/2收入）
     */
    @TableField(value = "trade_type")
    @ApiModelProperty(value="交易类型（1支出 2收入）")
    private Integer tradeType;

    /**
     * 交易时间
     */
    @TableField(value = "trade_time")
    @ApiModelProperty(value="交易时间")
    private Date tradeTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    //序列化
    private static final long serialVersionUID = 1L;
}
