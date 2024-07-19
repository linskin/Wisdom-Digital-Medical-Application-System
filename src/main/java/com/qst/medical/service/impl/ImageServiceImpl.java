package com.qst.medical.service.impl;

import com.qst.medical.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {
    @Value("${spring.web.resources.static-locations}")
    String staticLocation;
    public ResponseEntity<UrlResource> getFileByName(String filename) {
        try {
            Path file = Paths.get(staticLocation).resolve(filename);
            UrlResource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
