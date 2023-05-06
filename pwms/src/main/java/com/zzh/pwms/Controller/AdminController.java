package com.zzh.pwms.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.pwms.Entity.MerchantsInfo;
import com.zzh.pwms.Service.MerchantsInfoService;
import com.zzh.pwms.common.QueryPageParam;
import com.zzh.pwms.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
//解决跨域问题
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private MerchantsInfoService merchantsInfoService;

    @PostMapping("/adminListPage")
    public Result adminListPage(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        Page<MerchantsInfo> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        String search_inOn = (String)param.get("search_inOn");
        String search_merchantname = (String)param.get("search_merchantname");

        LambdaQueryWrapper<MerchantsInfo> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(search_inOn) && !"null".equals(search_inOn)){
            if(search_inOn.equals("启用"))
            {
                lambdaQueryWrapper.eq(MerchantsInfo::getIsOn,1);
            }
            else {
                lambdaQueryWrapper.eq(MerchantsInfo::getIsOn,0);
            }
        }
        //筛选所有permissiontype为0的，说明是商家
        lambdaQueryWrapper.eq(MerchantsInfo::getPermissionType,0);

        if(StringUtils.isNotBlank(search_merchantname) && !"null".equals(search_merchantname)){
            lambdaQueryWrapper.like(MerchantsInfo::getUsername,search_merchantname);
        }

        IPage result = merchantsInfoService.pageCC(page, lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());
        return Result.suc(result.getRecords(), result.getTotal());
    }

    // 更新商户信息中的状态类型
    @PostMapping("/updateState")
    public Result updateState(@RequestParam Integer id,@RequestParam Integer nextState) {
        MerchantsInfo merchantsInfo = new MerchantsInfo();
        merchantsInfo.setIsOn(nextState);
        merchantsInfo.setId(id);
        return merchantsInfoService.updateById(merchantsInfo)?Result.suc():Result.fail();
    }
}
