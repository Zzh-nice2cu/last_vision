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
 * 供应商信息表
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SupplierInfo对象", description="供应商信息表")
public class SupplierInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "供应商编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "供应商名称")
    private String name;

    @ApiModelProperty(value = "供应商地址")
    private String address;

    @ApiModelProperty(value = "供应商电话")
    private String phone;

    @ApiModelProperty(value = "供应商邮箱")
    private String email;

    @ApiModelProperty(value = "供应商联系人姓名")
    private String contactPerson;

    @ApiModelProperty(value = "供应商备注")
    private String remark;


}
