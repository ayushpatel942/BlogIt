package com.example.BlogIt.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {
    String uploadImage(String folderpath, MultipartFile file) throws IOException;
    InputStream serveImage(String folderpath, String filename) throws FileNotFoundException;
}