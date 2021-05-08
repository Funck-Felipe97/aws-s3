package com.funck.awss3.domain.application;

import org.springframework.web.multipart.MultipartFile;

public interface FileNameGenerator {

    String generateFileName(MultipartFile multiPart);

}
