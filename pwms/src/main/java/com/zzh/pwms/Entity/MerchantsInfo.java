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
 * 商家信息表
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="MerchantsInfo对象", description="商家信息表")
public class MerchantsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商家编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "商家用户名")
    private String username;

    @ApiModelProperty(value = "商家密码")
    private String password;

    @ApiModelProperty(value = "商家名称")
    private String name;

    @ApiModelProperty(value = "商家地址")
    private String address;

    @ApiModelProperty(value = "商家电话")
    private String phone;

    @ApiModelProperty(value = "商家邮箱")
    private String email;

    @ApiModelProperty(value = "商家备注")
    private String remark;

    @ApiModelProperty(value = "用户权限")
    private Integer permissionType;

    @ApiModelProperty(value = "是否启用")
    private Integer isOn;
}
