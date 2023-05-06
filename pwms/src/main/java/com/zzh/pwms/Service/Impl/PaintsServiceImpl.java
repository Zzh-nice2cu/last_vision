package com.zzh.pwms.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzh.pwms.Entity.Paints;
import com.zzh.pwms.Mapper.PaintsMapper;
import com.zzh.pwms.Service.PaintsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 涂料信息表 服务实现类
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Service
public class PaintsServiceImpl extends ServiceImpl<PaintsMapper, Paints> implements PaintsService {
    @Resource private  PaintsMapper paintsMapper;

    @Override
    public IPage pageCC(IPage<Paints> page, Wrapper wrapper) {
        return paintsMapper.pageCC(page,wrapper);
    }
}
