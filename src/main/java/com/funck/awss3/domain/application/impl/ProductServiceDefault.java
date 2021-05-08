package com.funck.awss3.domain.application.impl;

import com.funck.awss3.adapters.annotations.UseCase;
import com.funck.awss3.domain.application.FileUploadService;
import com.funck.awss3.domain.application.ProductRequest;
import com.funck.awss3.domain.application.ProductResponse;
import com.funck.awss3.domain.application.ProductService;
import com.funck.awss3.domain.entities.Product;
import com.funck.awss3.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class ProductServiceDefault implements ProductService {

    private final ProductRepository productRepository;
    private final FileUploadService amazonS3Service;

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = Product.builder()
                .description(request.getDescription())
                .imageUrl(amazonS3Service.upload(request.getImage()))
                .build();

        product = productRepository.add(product);

        return ProductResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .build();
    }

}
