package com.funck.awss3.interfaces;

import com.funck.awss3.domain.application.ProductRequest;
import com.funck.awss3.domain.application.ProductResponse;
import com.funck.awss3.domain.application.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/products")
public class ProductResource {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ProductResponse> create(@ModelAttribute final ProductRequest request) {
        return ResponseEntity.ok(productService.create(request));
    }

}
