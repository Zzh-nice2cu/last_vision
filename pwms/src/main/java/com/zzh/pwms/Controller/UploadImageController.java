package com.zzh.pwms.Controller;

import com.zzh.pwms.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
//解决跨域问题
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/upload")
public class UploadImageController {

    @PostMapping("/image")
    public Result uploadImage(@RequestParam("image") MultipartFile imageFile) {
        try {
            // 获取当前项目路径
            String projectPath = "C:/Users/15355/Desktop/毕设/last_vision/last_vision/pwms";
            // 获取静态资源路径
            String staticPath = projectPath + "/src/main/resources/static";
            // 获取保存图片的目录
            String imageDirPath = staticPath + "/images/";
            // 判断目录是否存在，不存在则创建
            File imageDir = new File(imageDirPath);
            if (!imageDir.exists()) {
                imageDir.mkdirs();
            }
            // 获取原始文件名
            String originalFilename = imageFile.getOriginalFilename();
            System.out.println("originalFilename==="+originalFilename);
            // 生成新的文件名
            //String newFilename = UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(originalFilename);
            // 构建文件对象
            File newFile = new File(imageDirPath, originalFilename);
            // 保存图片到指定的目录
            imageFile.transferTo(newFile);
            //System.out.println(newFilename);
            System.out.println(222);
            // 返回图片的访问路径
            return Result.suc(originalFilename);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("上传图片失败");
        }
    }

    @GetMapping("/getpic")
    public Result getFileNames() {
        File folder = new File("C:\\Users\\15355\\Desktop\\毕设\\last_vision\\last_vision\\pwms\\src\\main\\resources\\static\\images");

        File[] files = folder.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file : files) {
            if (file.isFile()) {
                fileNames.add(file.getName());
            }
        }
        String[] fileNameArray = fileNames.toArray(new String[0]);
        System.out.println(fileNameArray);
        return Result.suc(fileNameArray);
    }

//    @Autowired
//    ServletContext servletContext;
//
//    @PostMapping("/image")
//    public Result uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
//        // 判断文件是否为空
//        if (file.isEmpty()) {
//            return Result.fail("上传文件不能为空");
//        }
//
//        // 获取文件名和文件大小
//        String fileName = file.getOriginalFilename();
//
//        // 处理上传的图片文件，将图片保存到服务器的本地磁盘
//        // 获取保存路径
//        String uploadPath = servletContext.getRealPath("/") + "HomeImage/";
//        System.out.println(uploadPath);
//        // 创建File对象
//        File saveFile = new File(uploadPath + fileName);
//        // 将上传的文件保存到本地磁盘
//        file.transferTo(saveFile);
//        return Result.suc(uploadPath);
//    }


}
