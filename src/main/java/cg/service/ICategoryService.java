package cg.service;

import cg.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findOne(Long id);

    Category save(Category category);

    void delete(Long id);
}
