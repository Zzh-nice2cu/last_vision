package com.zzh.pwms.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.pwms.Entity.Paints;
import com.zzh.pwms.Entity.Record;
import com.zzh.pwms.Service.MerchantsInfoService;
import com.zzh.pwms.Service.PaintsService;
import com.zzh.pwms.Service.RecordService;
import com.zzh.pwms.common.QueryPageParam;
import com.zzh.pwms.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzh
 * @since 2023-05-02
 */
@RestController
//解决跨域问题
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;


    @GetMapping("/list")
    public List<Record> list(){
        return recordService.list();
    }


    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody Record record){
        return recordService.updateById(record);
    }

    //新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Record record){
        return recordService.saveOrUpdate(record)?Result.suc():Result.fail();
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Record record){
        return recordService.save(record)?Result.suc():Result.fail();
    }

    //删除
    @GetMapping("/delete")
    public boolean delete(@RequestParam Integer id){
        return recordService.removeById(id);
    }

//    //查询（模糊、匹配）
//    @PostMapping("/listP")
//    public Result listP(@RequestBody Record record){
//        LambdaQueryWrapper<Record> lambdaQueryWrapper = new LambdaQueryWrapper();
//        if(StringUtils.isNotBlank(record.getGoodId()){
//            lambdaQueryWrapper.like(Record::getName,record.getName());
//        }
//        return Result.suc(recordService.list(lambdaQueryWrapper),recordService.count(lambdaQueryWrapper)+0L);
//    }

    @PostMapping("/listPage")
    public Result listPageCC(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        Page<Record> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        String inOrOut = (String) param.get("search_inOrOut");
        String userName = (String) param.get("search_username");
        String paintName = (String) param.get("search_paintname");

        QueryWrapper<Record> queryWrapper = new QueryWrapper();
        //第一步先找涂料名称的，模糊查询
        if(StringUtils.isNotBlank(paintName) && !"null".equals(paintName)){
           //与数据库查出来的p.name进行模糊查询
            queryWrapper.like("p.name",paintName);
        }
        if(StringUtils.isNotBlank(userName) && !"null".equals(userName)){
            //与数据库查出来的m.username进行模糊查询
            queryWrapper.like("m.username",userName);
        }
        if(StringUtils.isNotBlank(inOrOut) && !"null".equals(inOrOut)){
            //与数据库查出来的p.name进行模糊查询
            if(inOrOut.equals("出库"))
            {
                queryWrapper.eq("r.in_or_out",0);
            }
            else {
                queryWrapper.eq("r.in_or_out",1);
            }
        }

        IPage result = recordService.pageCC(page, queryWrapper);
        System.out.println("total==" + result.getTotal());

        return Result.suc(result.getRecords(), result.getTotal());
    }
}
