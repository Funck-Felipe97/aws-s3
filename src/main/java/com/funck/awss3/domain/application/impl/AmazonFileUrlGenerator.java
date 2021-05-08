package com.funck.awss3.domain.application.impl;

import com.funck.awss3.adapters.annotations.UseCase;
import com.funck.awss3.config.AmazonS3Config;
import com.funck.awss3.domain.application.FileUrlGenerator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class AmazonFileUrlGenerator implements FileUrlGenerator {

    private final AmazonS3Config s3Config;

    @Override
    public String getUrl(String fileName) {
        return s3Config.getEndpointUrl() + "/" + s3Config.getBucketName() + "/" + fileName;
    }

}
