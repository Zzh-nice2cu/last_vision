package com.zzh.pwms.common;

public class other_page_method {
    //    @PostMapping("/listPage")
////    public List<Paints> listPage(@RequestBody HashMap map){
//    public List<Paints> listPage(@RequestBody QueryPageParam query){
//        HashMap param = query.getParam();
//        String name = (String)param.get("name");
//        System.out.println("name==="+(String)param.get("name"));
//        /*System.out.println("no==="+(String)param.get("no"));*/
//        /*LambdaQueryWrapper<Paints> lambdaQueryWrapper = new LambdaQueryWrapper();
//        lambdaQueryWrapper.eq(Paints::getName,paints.getName());
//
//        return paintsService.list(lambdaQueryWrapper);*/
//
//        Page<Paints> page = new Page();
//        page.setCurrent(query.getPageNum());
//        page.setSize(query.getPageSize());
//
//        LambdaQueryWrapper<Paints> lambdaQueryWrapper = new LambdaQueryWrapper();
//        lambdaQueryWrapper.like(Paints::getName,name);
//
//
//        IPage result = paintsService.page(page,lambdaQueryWrapper);
//
//        System.out.println("total=="+result.getTotal());
//
//        return result.getRecords();
//    }
//
//    @PostMapping("/listPageC")
//    public List<Paints> listPageC(@RequestBody QueryPageParam query){
//        HashMap param = query.getParam();
//        String name = (String)param.get("name");
//        System.out.println("name==="+(String)param.get("name"));
//
//
//
//        Page<Paints> page = new Page();
//        page.setCurrent(query.getPageNum());
//        page.setSize(query.getPageSize());
//
//        LambdaQueryWrapper<Paints> lambdaQueryWrapper = new LambdaQueryWrapper();
//        lambdaQueryWrapper.like(Paints::getName,name);
//
//
//        //IPage result = paintsService.pageC(page);
//        IPage result = paintsService.pageCC(page,lambdaQueryWrapper);
//
//        System.out.println("total=="+result.getTotal());
//
//        return result.getRecords();
//    }
//
//    @PostMapping("/listPageC1")
//    public Result listPageC1(@RequestBody QueryPageParam query){
//        HashMap param = query.getParam();
//        String name = (String)param.get("name");
//
//        Page<Paints> page = new Page();
//        page.setCurrent(query.getPageNum());
//        page.setSize(query.getPageSize());
//
//        LambdaQueryWrapper<Paints> lambdaQueryWrapper = new LambdaQueryWrapper();
//        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
//            lambdaQueryWrapper.like(Paints::getName,name);
//        }
//
//
//        //IPage result = paintsService.pageC(page);
//        IPage result = paintsService.pageCC(page,lambdaQueryWrapper);
//
//        System.out.println("total=="+result.getTotal());
//        System.out.println(result.getRecords());
//        return Result.suc(result.getRecords(),result.getTotal());
//    }
}
