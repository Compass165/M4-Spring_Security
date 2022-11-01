package com.blog.repository;


import com.blog.model.Blog;
import com.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepository extends PagingAndSortingRepository<Blog,Long> {
        Iterable<Blog> findAllByCategory(Category category);
        Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}