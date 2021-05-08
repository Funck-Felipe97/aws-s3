package com.funck.awss3.domain.application;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FileConverter {

    File toFile(MultipartFile multipartFile) throws IOException;

}
