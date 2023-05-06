package com.zzh.pwms.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商家库存表
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="MerchantsInventory对象", description="商家库存表")
public class MerchantsInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库存编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商家编号")
    private Integer merchantId;

    @ApiModelProperty(value = "涂料编号")
    private Integer paintId;

    @ApiModelProperty(value = "供应商编号")
    private Integer supplierId;

    @ApiModelProperty(value = "涂料单价")
    private Integer price;

    @ApiModelProperty(value = "当前库存数量")
    private Integer quantity;

    @ApiModelProperty(value = "最近入库时间")
    private String lastInDate;

    @ApiModelProperty(value = "最近出库时间")
    private String lastOutDate;

    @ApiModelProperty(value = "库存备注")
    private String remark;


}
