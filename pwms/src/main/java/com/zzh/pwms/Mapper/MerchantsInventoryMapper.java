package com.zzh.pwms.Mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zzh.pwms.Entity.MerchantsInventory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzh.pwms.Entity.Paints;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商家库存表 Mapper 接口
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Mapper
public interface MerchantsInventoryMapper extends BaseMapper<MerchantsInventory> {

    IPage pageCC(IPage<MerchantsInventory> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    Boolean updateIntime(Integer id,String lastInDate);

    Boolean updateOuttime(Integer id,String lastOutDate);
}
