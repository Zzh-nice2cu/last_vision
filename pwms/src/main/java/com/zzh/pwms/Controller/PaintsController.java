package com.zzh.pwms.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.pwms.Entity.MerchantsInfo;
import com.zzh.pwms.Entity.Paints;
import com.zzh.pwms.Service.PaintsService;
import com.zzh.pwms.common.QueryPageParam;
import com.zzh.pwms.common.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 涂料信息表 前端控制器
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@RestController
//解决跨域问题
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/paints")
public class PaintsController {

    @Autowired
    private PaintsService paintsService;

    @GetMapping("/list")
    public Result list(){
        return Result.suc(paintsService.list());
    }

    //根据Paintid查paint name
    @GetMapping("/findPaintnameById")
    public String findPaintnameById(@RequestParam Integer id) {
        List<Paints> list = paintsService.lambdaQuery().eq(Paints::getId,id).list();
        return list.get(0).getName();
    }

    @GetMapping("/findByName")
    public Result findByName(@RequestParam String name){
        List list = paintsService.lambdaQuery().eq(Paints::getName,name).list();
        return list.size()>0?Result.suc(list,list.size()+0L):Result.fail();
    }

    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody Paints paints){
        return paintsService.updateById(paints);
    }

    //新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Paints paints){
        return paintsService.saveOrUpdate(paints)?Result.suc():Result.fail();
    }

    //删除
    @GetMapping("/delete")
    public boolean delete(@RequestParam Integer id){
        return paintsService.removeById(id);
    }

    //查询（模糊、匹配）
    @PostMapping("/listP")
    public Result listP(@RequestBody Paints paints){
        LambdaQueryWrapper<Paints> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(paints.getName())){
            lambdaQueryWrapper.like(Paints::getName,paints.getName());
        }
        return Result.suc(paintsService.list(lambdaQueryWrapper),paintsService.count(lambdaQueryWrapper)+0L);
    }

    @PostMapping("/listPage")
    public Result listPageCC(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        Page<Paints> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        String name = (String)param.get("name");
        String brand = (String)param.get("brand");

        LambdaQueryWrapper<Paints> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(Paints::getName,name);
        }
        if(StringUtils.isNotBlank(brand) && !"null".equals(brand)){
            lambdaQueryWrapper.eq(Paints::getBrand,brand);
        }

        IPage result = paintsService.pageCC(page, lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());
        return Result.suc(result.getRecords(), result.getTotal());
    }

}
