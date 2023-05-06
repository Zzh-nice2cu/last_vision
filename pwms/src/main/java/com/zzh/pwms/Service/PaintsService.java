package com.zzh.pwms.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.pwms.Entity.Paints;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 涂料信息表 服务类
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
public interface PaintsService extends IService<Paints> {
    IPage pageCC(IPage<Paints> page, Wrapper wrapper);
}
