package com.zzh.pwms.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 涂料信息表
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Paints对象", description="涂料信息表")
public class Paints implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "涂料编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "涂料名称")
    private String name;

    @ApiModelProperty(value = "涂料品牌")
    private String brand;

    @ApiModelProperty(value = "涂料类型")
    private String type;

    @ApiModelProperty(value = "涂料计量单位")
    private String unit;

    @ApiModelProperty(value = "涂料备注")
    private String remark;


}
