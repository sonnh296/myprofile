package com.myprofile.myprofile.service;

import com.myprofile.myprofile.exceptions.FileDownloadException;
import com.myprofile.myprofile.exceptions.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadFile(MultipartFile multipartFile) throws FileUploadException, IOException;

    Object downloadFile(String fileName) throws FileDownloadException, IOException;

    boolean delete(String fileName);

}
