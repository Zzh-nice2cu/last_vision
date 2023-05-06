package com.zzh.pwms.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzh.pwms.Entity.MerchantsInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家信息表 服务类
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
public interface MerchantsInfoService extends IService<MerchantsInfo> {
    // 更新商户信息中的权限类型
    int updatePermissionType(@Param("id") Integer id, @Param("permissionType") Integer permissionType);

    List<MerchantsInfo> selectByPermissionType(Integer permissionType);

    IPage pageCC(IPage<MerchantsInfo> page, Wrapper wrapper);

}
