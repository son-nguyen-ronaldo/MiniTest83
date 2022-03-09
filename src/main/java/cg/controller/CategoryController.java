package cg.controller;

import cg.model.Category;
import cg.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> showAll(@PageableDefault(value = 10) Pageable pageable) {
        Page<Category> categories = iCategoryService.findAll(pageable);
        if (!categories.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category categoryCreate = iCategoryService.save(category);
        return new ResponseEntity<>(categoryCreate, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> editCategory(@RequestBody Category categoryEdit, @PathVariable("id") Long id) {
        Optional<Category> category = Optional.ofNullable(iCategoryService.findOne(id));
        if (!category.isPresent()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryEdit.setId(category.get().getId());
        categoryEdit = iCategoryService.save(categoryEdit);
        return new ResponseEntity<>(categoryEdit, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") Long id) {
        Optional<Category> category = Optional.ofNullable(iCategoryService.findOne(id));
        if (!category.isPresent()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCategoryService.delete(id);
        return new ResponseEntity<>(category.get(), HttpStatus.OK);
    }
}