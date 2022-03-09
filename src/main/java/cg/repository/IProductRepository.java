package cg.repository;

import cg.model.Category;
import cg.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
        Page<Product> findProductsByNameContaining(Pageable pageable, String search);

        Page<Product> findProductsByCategory(Pageable pageable, Category category);

        void deleteAllByCategory(Category category);
}
