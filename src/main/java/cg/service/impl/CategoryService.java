package cg.service.impl;

import cg.model.Category;
import cg.repository.ICategoryRepository;
import cg.service.ICategoryService;
import cg.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Autowired
    private IProductService iProductService;


    @Override
    public Page<Category> findAll(Pageable pageable) {
        return iCategoryRepository.findAll(pageable);
    }

    @Override
    public Category findOne(Long id) {
        if (iCategoryRepository.findById(id).isPresent()) {
            return iCategoryRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        Category category = findOne(id);
        iProductService.deleteAllByCategory(category);
        iCategoryRepository.deleteById(id);
    }
}
