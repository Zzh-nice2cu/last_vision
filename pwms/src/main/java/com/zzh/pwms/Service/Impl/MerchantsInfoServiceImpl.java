package com.zzh.pwms.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzh.pwms.Entity.MerchantsInfo;
import com.zzh.pwms.Mapper.MerchantsInfoMapper;
import com.zzh.pwms.Service.MerchantsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商家信息表 服务实现类
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Service
public class MerchantsInfoServiceImpl extends ServiceImpl<MerchantsInfoMapper, MerchantsInfo> implements MerchantsInfoService {

    @Autowired
    private MerchantsInfoMapper merchantsInfoMapper;

    @Override
    public int updatePermissionType(Integer id, Integer permissionType) {
        return merchantsInfoMapper.updatePermissionType(id, permissionType);
    }

    @Override
    public List<MerchantsInfo> selectByPermissionType(Integer permissionType) {
        return merchantsInfoMapper.selectByPermissionType(permissionType);
    }

    @Override
    public IPage pageCC(IPage<MerchantsInfo> page, Wrapper wrapper) {
        return merchantsInfoMapper.pageCC(page,wrapper);
    }

}
