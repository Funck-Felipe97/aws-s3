package com.funck.awss3.domain.application;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductRequest {

    private String description;
    private MultipartFile image;

}
