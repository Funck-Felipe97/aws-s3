package com.funck.awss3.domain.application;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductResponse {

    private Long id;
    private String description;
    private String imageUrl;

}
