package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import org.lieying.utils.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    @RequestMapping(value = "/upload", produces = "text/plain;charset=UTF-8")
    public String uploadCompanyFile(@RequestParam("file") MultipartFile file,
                                    HttpServletRequest request) throws FileNotFoundException {
        File dirFile = new File(request.getServletContext().getRealPath("/uploads"));
        String originalFilename = file.getOriginalFilename();    //获取原文件名
        String newFilename = UUID.randomUUID() + "_" + originalFilename;    //使用UUID避免重名
        Boolean result= FileUtils.uploadFile(file,dirFile,newFilename);
        if (result){
            return newFilename;
        } else {
            return "err";
        }

    }

}
