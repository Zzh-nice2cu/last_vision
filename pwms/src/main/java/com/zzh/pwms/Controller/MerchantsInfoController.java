package com.zzh.pwms.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.pwms.Entity.MerchantsInfo;
import com.zzh.pwms.Entity.Paints;
import com.zzh.pwms.Service.MerchantsInfoService;
import com.zzh.pwms.common.QueryPageParam;
import com.zzh.pwms.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 商家信息表 前端控制器
 * </p>
 *
 * @author zzh
 * @since 2023-04-18
 */
@RestController
//解决跨域问题
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("merchantsInfo")
public class MerchantsInfoController {
    @Autowired
    MerchantsInfoService merchantsInfoService;

    //查找所有用户（permissionType=0）
    @GetMapping("/listallmerchants")
    public Result listallmerchants(@RequestParam Integer permissionType){
        List list = merchantsInfoService.lambdaQuery().eq(MerchantsInfo::getPermissionType,permissionType).list();
        return list.size()>0?Result.suc(list):Result.fail();
    }

    //根据user id查user name
    @GetMapping("/findUsernameById")
    public String findUsernameById(@RequestParam Integer userId) {
        List<MerchantsInfo> list = merchantsInfoService.lambdaQuery().eq(MerchantsInfo::getId,userId).list();
        return list.get(0).getUsername();
    }


    //根据用户名查找
    @GetMapping("/findByName")
    public Result findByName(@RequestParam String username){
        List list = merchantsInfoService.lambdaQuery().eq(MerchantsInfo::getUsername,username).list();
        return list.size()>0?Result.suc(list,list.size()+0L):Result.fail();
    }

    //登陆验证
    @PostMapping("/login")
    public Result login(@RequestBody MerchantsInfo merchantsInfo){
        List list = merchantsInfoService.lambdaQuery().eq(MerchantsInfo::getUsername,merchantsInfo.getUsername()).
                eq(MerchantsInfo::getPassword,merchantsInfo.getPassword()).list();
        return list.size()>0?Result.suc(list.get(0)):Result.fail();
    }

    @PostMapping("/save")
    public Result save(@RequestBody MerchantsInfo merchantsInfo){
        return merchantsInfoService.save(merchantsInfo)?Result.suc():Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody MerchantsInfo merchantsInfo){
        return merchantsInfoService.updateById(merchantsInfo)?Result.suc():Result.fail();
    }

    //更新密码
    @PostMapping("/updatepsd")
    public Result updatepsd(@RequestParam Integer id,@RequestParam String newpsd){
        MerchantsInfo merchantsInfo = new MerchantsInfo();
        merchantsInfo.setPassword(newpsd);
        merchantsInfo.setId(id);
        return merchantsInfoService.updateById(merchantsInfo)?Result.suc():Result.fail();
    }

    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String id){
        return merchantsInfoService.removeById(id)?Result.suc():Result.fail();
    }

    //查询（模糊、匹配）
    @PostMapping("/listP")
    public Result listP(@RequestBody MerchantsInfo merchantsInfo){
        LambdaQueryWrapper<MerchantsInfo> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(merchantsInfo.getUsername())){
            lambdaQueryWrapper.like(MerchantsInfo::getUsername,merchantsInfo.getUsername());
        }
        //suc函数第二个参数要Long，但是count是返回int，所以在后面+0L转化为Long型数据
        return Result.suc(merchantsInfoService.list(lambdaQueryWrapper),merchantsInfoService.count(lambdaQueryWrapper)+0L);
    }

    @PostMapping("/listPage")
    public Result listPageCC(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        Page<MerchantsInfo> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        String name = (String)param.get("name");
        System.out.println(query);

        LambdaQueryWrapper<MerchantsInfo> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(MerchantsInfo::getName,name);
        }
        IPage result = merchantsInfoService.pageCC(page, lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());
        return Result.suc(result.getRecords(), result.getTotal());
    }
}
