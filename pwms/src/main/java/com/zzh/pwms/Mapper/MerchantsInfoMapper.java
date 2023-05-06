package com.zzh.pwms.Mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zzh.pwms.Entity.MerchantsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzh.pwms.Entity.Paints;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家信息表 Mapper 接口
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Mapper
public interface MerchantsInfoMapper extends BaseMapper<MerchantsInfo> {

    int updatePermissionType(Integer id, Integer permissionType);

    List<MerchantsInfo> selectByPermissionType(Integer permissionType);

    IPage pageCC(IPage<MerchantsInfo> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
