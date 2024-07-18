package com.qst.medical.service;

import com.qst.medical.util.Msg;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    Msg upload(MultipartFile file);
}
