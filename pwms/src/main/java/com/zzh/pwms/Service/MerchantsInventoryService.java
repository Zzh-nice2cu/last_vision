package com.zzh.pwms.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.pwms.Entity.MerchantsInventory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzh.pwms.Entity.Paints;
import com.zzh.pwms.Entity.Record;

/**
 * <p>
 * 商家库存表 服务类
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
public interface MerchantsInventoryService extends IService<MerchantsInventory> {

    IPage pageCC(IPage<MerchantsInventory> page, Wrapper wrapper);

    Boolean updateIntime(Integer id,String lastInDate);

    Boolean updateOuttime(Integer id,String lastOutDate);
}
