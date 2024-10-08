package com.qst.medical.service.impl;


import com.qst.medical.service.FileUploadService;
import com.qst.medical.util.Msg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 文件上传业务逻辑类
 *
 * @author liulindong
 * @since 2021年8月19日22:05:16
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Value("${download.location}")
    String downloadLocation;
    @Value("${download.bashUrl}")
    String bashUrl;

    public Msg upload(MultipartFile file){

        byte[] bs = new byte[1024];
        String path = downloadLocation;
        File tmpFile=new File(path);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }

        String fileName;
        fileName = UUID.randomUUID()+file.getOriginalFilename();

        int len;
        try(
                InputStream inputStream = file.getInputStream();
                OutputStream os = new FileOutputStream(tmpFile.getPath()+File.separator+fileName);
                ) {
            while((len=inputStream.read(bs))!=-1){
                os.write(bs,0,len);
            }

        } catch (IOException e) {
            return Msg.fail().mess("上传失败");
        }
        String url = bashUrl+fileName;
        return Msg.success().mess("上传成功").data("url",url);

    }
}