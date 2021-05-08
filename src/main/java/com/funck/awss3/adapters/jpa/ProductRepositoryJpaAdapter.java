package com.funck.awss3.adapters.jpa;

import com.funck.awss3.domain.entities.Product;
import com.funck.awss3.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryJpaAdapter implements ProductRepository {

    private final ProductEntityRepository productEntityRepository;
    private final ProductMapper mapper;

    @Override
    public Optional<Product> findById(Long id) {
        return productEntityRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Product add(Product product) {
        return mapper.toDomain(
                productEntityRepository.saveAndFlush(mapper.toJpaModel(product))
        );
    }

    @Override
    public Product update(Product product) {
        return mapper.toDomain(
                productEntityRepository.saveAndFlush(mapper.toJpaModel(product))
        );
    }

    @Override
    public void remove(Product product) {
        productEntityRepository.delete(mapper.toJpaModel(product));
    }

    @Override
    public void remove(Long id) {
        productEntityRepository.deleteById(id);
    }

    @Override
    public List<Product> listAll() {
        return mapper.toDomainList(productEntityRepository.findAll());
    }

}
