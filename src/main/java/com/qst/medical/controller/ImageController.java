package com.qst.medical.controller;

import com.qst.medical.service.impl.ImageServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "图片控制器")
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageServiceImpl imageService;

    @GetMapping("/{filename:.+}")
    public ResponseEntity<UrlResource> serveFile(@PathVariable String filename) {
        return imageService.getFileByName(filename);
    }
}
