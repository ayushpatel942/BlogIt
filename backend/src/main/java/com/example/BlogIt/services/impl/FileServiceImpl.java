package com.example.BlogIt.services.impl;

import com.example.BlogIt.services.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String folderpath, MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public InputStream serveImage(String folderpath, String filename) throws FileNotFoundException {
        return null;
    }
}
