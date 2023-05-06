package com.zzh.pwms.Mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zzh.pwms.Entity.Paints;
import com.zzh.pwms.Entity.SupplierInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 供应商信息表 Mapper 接口
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Mapper
public interface SupplierInfoMapper extends BaseMapper<SupplierInfo> {

    IPage pageCC(IPage<SupplierInfo> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
