package com.qst.medical.service;

import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;

public interface ImageService {
    ResponseEntity<UrlResource> getFileByName(String filename);
}
