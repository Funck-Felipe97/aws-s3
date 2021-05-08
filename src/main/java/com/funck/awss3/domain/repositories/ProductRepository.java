package com.funck.awss3.domain.repositories;

import com.funck.awss3.domain.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(Long id);

    Product add(Product product);

    Product update(Product product);

    void remove(Product product);

    void remove(Long id);

    List<Product> listAll();

}
