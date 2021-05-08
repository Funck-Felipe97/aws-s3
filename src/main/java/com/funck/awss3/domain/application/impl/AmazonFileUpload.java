package com.funck.awss3.domain.application.impl;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.funck.awss3.adapters.annotations.UseCase;
import com.funck.awss3.domain.application.FileConverter;
import com.funck.awss3.domain.application.FileNameGenerator;
import com.funck.awss3.domain.application.FileUploadService;
import com.funck.awss3.config.AmazonS3Config;
import com.funck.awss3.domain.application.FileUrlGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RequiredArgsConstructor
@UseCase
public class AmazonFileUpload implements FileUploadService {

    private final AmazonS3Client s3client;
    private final AmazonS3Config s3Config;
    private final FileConverter fileConverter;
    private final FileNameGenerator fileNameGenerator;
    private final FileUrlGenerator fileUrlGenerator;

    @Override
    public String upload(MultipartFile multipartFile) {
        String fileUrl = "";
        try {
            File file = fileConverter.toFile(multipartFile);
            String fileName = fileNameGenerator.generateFileName(multipartFile);
            fileUrl = fileUrlGenerator.getUrl(fileName);
            upload(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }

    private void upload(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(s3Config.getBucketName(), fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

}
