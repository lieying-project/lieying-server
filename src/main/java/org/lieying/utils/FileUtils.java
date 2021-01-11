package org.lieying.utils;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUtils {


    public static Boolean uploadFile(MultipartFile uploadfile,File dirFile,String newFilename){
        //判断路径是否存在，不存在则创建
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        //判断上传文件是否为空
        if (!uploadfile.isEmpty()) {
            try {
                File f=new File(dirFile.getPath() +"/"+ newFilename);
                uploadfile.transferTo(f);
            } catch (Exception e) {
                e.printStackTrace();
                return  false;
            }
        }



        return  true;
    }


}