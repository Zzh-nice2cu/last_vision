package com.zzh.pwms.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzh.pwms.Entity.SupplierInfo;
import com.zzh.pwms.Mapper.SupplierInfoMapper;
import com.zzh.pwms.Service.SupplierInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 供应商信息表 服务实现类
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Service
public class SupplierInfoServiceImpl extends ServiceImpl<SupplierInfoMapper, SupplierInfo> implements SupplierInfoService {

    @Resource
    private  SupplierInfoMapper supplierInfoMapper;

    @Override
    public IPage pageCC(IPage<SupplierInfo> page, Wrapper wrapper) {
        return supplierInfoMapper.pageCC(page,wrapper);
    }
}
