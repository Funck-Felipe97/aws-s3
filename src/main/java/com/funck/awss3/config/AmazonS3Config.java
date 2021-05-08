package com.funck.awss3.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AmazonS3Config {

    private final String endpointUrl;
    private final String bucketName;
    private final String accessKey;
    private final String secretKey;

    public AmazonS3Config(
            @Value("${amazonProperties.endpointUrl}") String endpointUrl,
            @Value("${amazonProperties.bucketName}") String bucketName,
            @Value("${amazonProperties.accessKey}") String accessKey,
            @Value("${amazonProperties.secretKey}") String secretKey
    ) {
        this.endpointUrl = endpointUrl;
        this.bucketName = bucketName;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

}
