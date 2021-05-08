package com.funck.awss3.adapters.jpa;

import com.funck.awss3.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ProductMapper {

    private final ModelMapper mapper;

    public Product toDomain(ProductEntity productEntity) {
        return mapper.map(productEntity, Product.class);
    }

    public List<Product> toDomainList(List<ProductEntity> productEntities) {
        return productEntities.stream().map(this::toDomain).collect(Collectors.toList());
    }

    public ProductEntity toJpaModel(Product product) {
        return mapper.map(product, ProductEntity.class);
    }

    public List<ProductEntity> toJpaModelList(List<Product> products) {
        return products.stream().map(this::toJpaModel).collect(Collectors.toList());
    }

}
