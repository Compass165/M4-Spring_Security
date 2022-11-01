package com.blog.service.blog;

import com.blog.model.Blog;
import com.blog.model.Category;
import com.blog.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    void remove(Long e);

    Blog findById(Long id);

    Iterable<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
