package com.blog.service.category;

import com.blog.model.Category;
import com.blog.service.IGeneralService;

public interface ICategoryService extends IGeneralService<Category> {
    Iterable<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
