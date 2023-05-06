package com.zzh.pwms.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.pwms.Entity.Paints;
import com.zzh.pwms.Entity.SupplierInfo;
import com.zzh.pwms.Service.SupplierInfoService;
import com.zzh.pwms.common.QueryPageParam;
import com.zzh.pwms.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 供应商信息表 前端控制器
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@RestController
//解决跨域问题
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/supplier")
public class SupplierInfoController {
    @Autowired
    SupplierInfoService supplierInfoService;

    @GetMapping("/list")
    public Result list(){
        return Result.suc(supplierInfoService.list());
    }

    @GetMapping("/findByName")
    public Result findByName(@RequestParam String name){
        List list = supplierInfoService.lambdaQuery().eq(SupplierInfo::getName,name).list();
        return list.size()>0?Result.suc(list,list.size()+0L):Result.fail();
    }

    @PostMapping("/save")
    public Result save(@RequestBody SupplierInfo supplierInfo){
        return supplierInfoService.save(supplierInfo)?Result.suc():Result.fail();
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody SupplierInfo supplierInfo){
        return supplierInfoService.saveOrUpdate(supplierInfo)?Result.suc():Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody SupplierInfo supplierInfo){
        return supplierInfoService.updateById(supplierInfo)?Result.suc():Result.fail();
    }
    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String id){
        return supplierInfoService.removeById(id)?Result.suc():Result.fail();
    }

    //查询（模糊、匹配）
    @PostMapping("/listP")
    public Result listP(@RequestBody SupplierInfo supplierInfo){
        LambdaQueryWrapper<SupplierInfo> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(supplierInfo.getName())){
            lambdaQueryWrapper.like(SupplierInfo::getName,supplierInfo.getName());
        }
        //suc函数第二个参数要Long，但是count是返回int，所以在后面+0L转化为Long型数据
        return Result.suc(supplierInfoService.list(lambdaQueryWrapper),supplierInfoService.count(lambdaQueryWrapper)+0L);
    }

    @PostMapping("/listPage")
    public Result listPageCC(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        Page<SupplierInfo> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        String name = (String)param.get("name");
        System.out.println(query);

        LambdaQueryWrapper<SupplierInfo> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(SupplierInfo::getName,name);
        }
        IPage result = supplierInfoService.pageCC(page, lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());
        return Result.suc(result.getRecords(), result.getTotal());
    }
}
