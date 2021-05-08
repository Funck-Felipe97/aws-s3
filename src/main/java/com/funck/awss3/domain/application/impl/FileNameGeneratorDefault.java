package com.funck.awss3.domain.application.impl;

import com.funck.awss3.adapters.annotations.UseCase;
import com.funck.awss3.domain.application.FileNameGenerator;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@UseCase
public class FileNameGeneratorDefault implements FileNameGenerator {

    @Override
    public synchronized String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

}
