package com.funck.awss3.domain.application.impl;

import com.funck.awss3.adapters.annotations.UseCase;
import com.funck.awss3.domain.application.FileConverter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@UseCase
public class DefaultFileConverter implements FileConverter {

    @Override
    public File toFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;
    }

}
