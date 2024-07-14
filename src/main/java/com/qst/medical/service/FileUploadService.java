package com.qst.medical.service;


import com.qst.medical.util.Msg;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * 文件上传业务逻辑类
 *
 * @author liulindong
 * @since 2021年8月19日22:05:16
 */
@Service
public class FileUploadService {
    @Value("${download.location}")
    String downloadLocation;
    @Value("${download.bashUrl}")
    String bashUrl;
    /**
     * 上传文件至华为云
     * @param file
     * @return
     */
//    public Msg upload(MultipartFile file) {
//
//        System.out.println("进入了service");
//        String endPoint = "https://obs.cn-east-2.myhuaweicloud.com";
//        String ak = "9TJBIQHH9SA9B1HXON2K";
//        String sk = "F9hLLVdPBeszJoCLo11s23NsmSbLXLGChKubgUgw";
//        // 创建ObsClient实例
//        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
//        String dateStr = new DateTime().toString("yyyy/MM/dd");
//        String uid = UUID.randomUUID().toString().replace("-","");
//        String fileName = dateStr+"/"+uid+file.getOriginalFilename();
//        System.out.println(fileName);
//        try {
//            PutObjectResult result = obsClient.putObject("lld66", fileName, file.getInputStream());
//        } catch (IOException e) {
//            return Msg.fail().mess("文件上传失败");
//        }
//        String url = "https://lld66.obs.cn-east-2.myhuaweicloud.com/"+fileName;
//        return Msg.success().data("url",url).mess("文件上传成功");
//    }
    public Msg upload(MultipartFile file){
        OutputStream os = null;
        InputStream inputStream = null;
        String fileName = null;
        int len;
        try {
            inputStream = file.getInputStream();
            fileName = UUID.randomUUID()+file.getOriginalFilename();
            String path = downloadLocation;
            byte[] bs = new byte[1024];
            File tmpFile=new File(path);
            if (!tmpFile.exists()) {
                tmpFile.mkdirs();
            }
            os =new FileOutputStream(tmpFile.getPath()+File.separator+fileName);
            while((len=inputStream.read(bs))!=-1){
                os.write(bs,0,len);
            }
            os.close();
            inputStream.close();
        } catch (IOException e) {
            return Msg.fail().mess("上传失败");
        }
        String url = bashUrl+fileName;
        return Msg.success().mess("上传成功").data("url",url);

    }

//    public byte[] getFile(String filename) throws IOException {
//
//        File f=new File("./src/main/resources/static/"+filename);
//        FileInputStream fi=new FileInputStream(f);
//        byte[] b=new byte[fi.available()];
//        return b;
//    }
}