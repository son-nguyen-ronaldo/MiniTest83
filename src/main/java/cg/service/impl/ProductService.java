package cg.service.impl;

import cg.model.Category;
import cg.model.Product;
import cg.repository.IProductRepository;
import cg.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findOne(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Page<Product> findProductsByNameContaining(Pageable pageable, String search) {
        return iProductRepository.findProductsByNameContaining(pageable, search);
    }

    @Override
    public Page<Product> findProductsByCategory(Pageable pageable, Category category) {
        return iProductRepository.findProductsByCategory(pageable, category);
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public void deleteAllByCategory(Category category) {
        iProductRepository.deleteAllByCategory(category);
    }
}
