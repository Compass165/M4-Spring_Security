package com.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneralService <T>{
    Page<T> findAll(Pageable pageable);

    void save(T model);

    void remove(Long id);

    T findById (Long id);
}
