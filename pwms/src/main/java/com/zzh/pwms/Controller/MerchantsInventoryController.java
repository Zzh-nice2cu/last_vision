package com.zzh.pwms.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zzh.pwms.Entity.MerchantsInventory;
import com.zzh.pwms.Service.MerchantsInventoryService;

import com.zzh.pwms.common.QueryPageParam;
import com.zzh.pwms.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 商家库存表 前端控制器
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@RestController
//解决跨域问题
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/inventory")
public class MerchantsInventoryController {
    @Autowired
    private MerchantsInventoryService merchantsInventoryService;


    @GetMapping("/findByMerchantId")
    public Result findByNo(@RequestParam Integer id){
        //根据商家id列出所有库存
        List list = merchantsInventoryService.lambdaQuery().eq(MerchantsInventory::getMerchantId,id).list();
        return list.size()>0?Result.suc(list,list.size()+0L):Result.fail();
    }

    //修改
    @PostMapping("/mod")
    public Result mod(@RequestBody MerchantsInventory merchantsInventory,@RequestParam Integer way){
        if(way==1){
            //入库，改入库时间
            merchantsInventoryService.updateIntime(merchantsInventory.getId(),merchantsInventory.getLastInDate());
        }
        else {
            merchantsInventoryService.updateOuttime(merchantsInventory.getId(),merchantsInventory.getLastOutDate());
        }
        return merchantsInventoryService.updateById(merchantsInventory)?Result.suc(merchantsInventory):Result.fail();
    }

    //新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody MerchantsInventory merchantsInventory){
        return merchantsInventoryService.saveOrUpdate(merchantsInventory)?Result.suc(merchantsInventory):Result.fail();
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody MerchantsInventory merchantsInventory){
        return merchantsInventoryService.save(merchantsInventory)?Result.suc(merchantsInventory):Result.fail();
    }

    //新增或修改
    @PostMapping("/modOnly")
    public Result modOnly(@RequestBody MerchantsInventory merchantsInventory){
        return merchantsInventoryService.updateById(merchantsInventory)?Result.suc(merchantsInventory):Result.fail();
    }

    //删除
    @GetMapping("/del")
    public Result delete(@RequestParam Integer id){
        return merchantsInventoryService.removeById(id)?Result.suc():Result.fail();
    }


    @PostMapping("/listPage")
    public Result listPageCC(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        Page<MerchantsInventory> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        String search_suppliername = (String) param.get("search_suppliername");
        String paintName = (String) param.get("search_paintname");
        Integer userId = (Integer) param.get("user_id");

        QueryWrapper<MerchantsInventory> queryWrapper = new QueryWrapper();
        //第一步先找涂料名称的，模糊查询
        if(StringUtils.isNotBlank(paintName) && !"null".equals(paintName)){
            //与数据库查出来的p.name进行模糊查询
            queryWrapper.like("p.name",paintName);
        }
        if(StringUtils.isNotBlank(search_suppliername) && !"null".equals(search_suppliername)){
            //与数据库查出来的s.name进行模糊查询
            queryWrapper.like("s.name",search_suppliername);
        }

        //限定当前 用户的库存
        queryWrapper.eq("m.id",userId);

        IPage result = merchantsInventoryService.pageCC(page, queryWrapper);
        System.out.println("total==" + result.getTotal());
        return Result.suc(result.getRecords(), result.getTotal());
    }
}
