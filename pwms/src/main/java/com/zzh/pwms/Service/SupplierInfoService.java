package com.zzh.pwms.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.pwms.Entity.Paints;
import com.zzh.pwms.Entity.SupplierInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 供应商信息表 服务类
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
public interface SupplierInfoService extends IService<SupplierInfo> {

    IPage pageCC(IPage<SupplierInfo> page, Wrapper wrapper);
}
