package cg.service;

import cg.model.Category;
import cg.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findOne(Long id);

    Page<Product> findProductsByNameContaining(Pageable pageable, String search);

    Page<Product> findProductsByCategory(Pageable pageable, Category category);

    Product save(Product product);

    void delete(Long id);

    void deleteAllByCategory(Category category);
}
