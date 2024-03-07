package com.example.BlogIt.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {
    boolean isImageWithValidExtension(MultipartFile file);
}