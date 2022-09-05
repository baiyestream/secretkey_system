package com.example.controller;

import com.example.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * 文件上传和下载
 *
 *        文件上传时，对页面的form表单有如下要求：
 *        method="post" 采用post方式提交数据
 *        enctype:"multipart/form-data" 采用multipart格式上传文件
 *        type="file" 使用input的file控件上传
 *
 *        举例：
 *        <form method = "post" action= "/common/upload" enctype="multipart/form-data"
 *            <input name = "myFile" type = "file" />
 *            <input type = "submit" value = "提交" />
 *
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Value("${tangcai.path}")
    private String basePath;

    /**
     * 文件上传,秘钥系统里的添加文件
     * param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> uploadFile(MultipartFile file){

        // 原始文件名
        String originalFilename = file.getOriginalFilename(); // abc.apk

        // 创建一个目录对象
        File dir = new File(basePath);
        // 判断当前目录是否存在
        if(!dir.exists()){
            // 目录不存在，需要创建
            dir.mkdirs();
        }
        try {
            // 将临时文件转存到指定位置
            file.transferTo(new File(basePath+originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(originalFilename);
    }

    /**
     * 文件下载
     * @param file
     * @param response
     */
    @GetMapping("/download")
    public void downloadFile(String file, HttpServletResponse response){

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(basePath+file));
            // 输出流，通过输出流将文件写会浏览器，在浏览器展示文件
            ServletOutputStream outputStream = response.getOutputStream();

            // 安卓文件
//            response.setContentType("application/vnd.android.package-archive");
            // 图片文件
            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while((len = fileInputStream.read(bytes))!=-1 ){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }

            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delete")
    public R<String> deleteFile(String file,HttpServletResponse response){
        File filename = new File(basePath+file);

        if (filename == null || !filename.exists()) {
            return R.error("文件不存在");
        }
        try {
            // “isFile()函数是Java中File类的一部分。此函数确定是文件名还是用抽象文件名表示的目录是File。
            // 如果抽象文件路径为File,则该函数返回true;否则,返回false。
            if (filename.isFile()) {
            }
            else {
                // 文件夹, 需要先删除文件夹下面所有的文件, 然后删除
                for (File temp : filename.listFiles()) {
                    temp.delete();
                }
            }
            filename.delete();
        } catch (Exception e) {
            log.error("发生错误: {}", e);
            return R.error("删除失败");
        }

        return R.success("删除成功");
    }


}
