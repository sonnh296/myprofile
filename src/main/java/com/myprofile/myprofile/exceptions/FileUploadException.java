package com.myprofile.myprofile.exceptions;

public class FileUploadException extends SpringBootFileUploadException{
    public FileUploadException(String message) {
        super(message);
    }
}
