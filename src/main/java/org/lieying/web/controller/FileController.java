package org.lieying.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lieying.utils.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.*;

import java.util.UUID;

@Api(value = "文件信息接口",tags = "文件信息")
@RestController
@RequestMapping("/file")
public class FileController {

    @ApiOperation(value = "上传文件",notes="上传文件")
    @RequestMapping(value = "/upload", produces = "text/plain;charset=UTF-8")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             HttpServletRequest request) {
        File dirFile = new File(request.getServletContext().getRealPath("/resources/uploads"));
        String originalFilename = file.getOriginalFilename();    //获取原文件名
        String newFilename = UUID.randomUUID() + "_" + originalFilename;    //使用UUID避免重名
        Boolean result = FileUtils.uploadFile(file, dirFile, newFilename);
        // FileUtils.uploadFile(file,new File("E:\\project\\java\\lieying\\src\\main\\webapp\\resources\\uploads"),newFilename);
        if (result) {
            return "http://localhost:8080/lieying/uploads/" + newFilename;
        } else {
            return "err";
        }

    }

//
//    @RequestMapping(value = "/download")
//    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("file") String filename,
//                                           @RequestHeader("User-Agent") String userAgent) throws IOException {
//        // 下载文件的路径
//        String path = request.getServletContext().getRealPath("/resources/uploads/");
//        // 构建Filepath + File.separator +
//        Integer prefixLen=filename.substring(0,filename.indexOf("/uploads")).length()+9;
//        System.out.println(prefixLen);
//
//        filename=filename.substring(prefixLen,filename.length());
//       System.out.println(filename);
//        File file = new File(path+ filename);
//        // ok表示http请求中状态码200
//        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
//        // 内容长度
//
//        builder.contentLength(file.length());
//                 // application/octet-stream 二进制数据流（最常见的文件下载）
//        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
//        // 使用URLEncoding.decode对文件名进行解码
//        filename = URLEncoder.encode(filename, "UTF-8");
//        // 根据浏览器类型，决定处理方式
//        if (userAgent.indexOf("MSIE") > 0) {
//            builder.header("Content-Disposition", "attachment; filename=" + filename);
//        } else {
//            builder.header("Content-Disposition", "attacher; filename*=UTF-8''" + filename);
//        }
//        return builder.body(org.apache.commons.io.FileUtils.readFileToByteArray(file));
//    }



    /*
    * 下载文件
    * */
    @ApiOperation(value = "下载文件",notes="下载文件")
    @RequestMapping("/download")
    public ResponseEntity<byte[]> fileDownLoad(@RequestParam("file") String filename,
                                         @RequestHeader("User-Agent") String userAgent,
                                           HttpServletRequest request
                                               ) throws Exception{
        String path = request.getServletContext().getRealPath("/resources/uploads/");
        // 构建Filepath + File.separator +
        Integer prefixLen=filename.substring(0,filename.indexOf("/uploads")).length()+9;
        System.out.println(prefixLen);

        filename=filename.substring(prefixLen,filename.length());
       System.out.println(filename);
        File file = new File(path+ filename);
        InputStream in=new FileInputStream(file);//将该文件加入到输入流之中
        byte[] body=null;
        body=new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
        in.read(body);//读入到输入流里面
        filename=new String(filename.getBytes("gbk"),"iso8859-1");//防止中文乱码
        HttpHeaders headers=new HttpHeaders();//设置响应头
        headers.add("Content-Disposition", "attachment;filename="+filename);
        HttpStatus statusCode = HttpStatus.OK;//设置响应吗
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;

        //public ResponseEntity（T  body，
        //                       MultiValueMap < String，String > headers，
        //                       HttpStatus  statusCode）
        //HttpEntity使用给定的正文，标题和状态代码创建一个新的。
        //参数：
        //body - 实体机构
        //headers - 实体头
        //statusCode - 状态码
    }
}
