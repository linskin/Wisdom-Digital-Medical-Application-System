package com.qst.medical.controller;

import com.qst.medical.service.impl.FileUploadServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;

/**
 * 文件上传至华为云OBS对象存储控制器
 *
 * @author liulindong
 * @since 2021年8月19日21:52:58
 */
@Api(tags = "文件上传控制器")
@RestController
@RequestMapping("/api/base/upload")
@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileUploadServiceImpl fileUploadServiceImpl;

    /**
     * 上传文件至华为云
     */
    @RolesAllowed({"1","2"})
    @PostMapping(value = "")
    public Msg fileUpload(MultipartFile file) {
        return fileUploadServiceImpl.upload(file);
    }
}