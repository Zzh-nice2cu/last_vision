package com.zzh.pwms.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzh.pwms.Entity.MerchantsInventory;
import com.zzh.pwms.Entity.Paints;
import com.zzh.pwms.Mapper.MerchantsInventoryMapper;
import com.zzh.pwms.Mapper.PaintsMapper;
import com.zzh.pwms.Service.MerchantsInventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 商家库存表 服务实现类
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Service
public class MerchantsInventoryServiceImpl extends ServiceImpl<MerchantsInventoryMapper, MerchantsInventory> implements MerchantsInventoryService {
    @Resource
    private MerchantsInventoryMapper merchantsInventoryMapper;


    @Override
    public IPage pageCC(IPage<MerchantsInventory> page, Wrapper wrapper) {
        return merchantsInventoryMapper.pageCC(page,wrapper);
    }

    @Override
    public Boolean updateIntime(Integer id,String lastInDate) {
        return merchantsInventoryMapper.updateIntime(id,lastInDate);
    }

    @Override
    public Boolean updateOuttime(Integer id,String lastOutDate) {
        return merchantsInventoryMapper.updateOuttime(id,lastOutDate);
    }
}
