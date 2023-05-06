package com.zzh.pwms.Mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zzh.pwms.Entity.Paints;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 涂料信息表 Mapper 接口
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@Mapper
public interface PaintsMapper extends BaseMapper<Paints> {
   IPage pageCC(IPage<Paints> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
