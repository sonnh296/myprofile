package com.myprofile.myprofile.exceptions;

public class FileDownloadException extends SpringBootFileUploadException{
    public FileDownloadException(String message) {
        super(message);
    }
}
