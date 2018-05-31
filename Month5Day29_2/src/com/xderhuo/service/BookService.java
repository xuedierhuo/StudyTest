package com.xderhuo.service;

import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.Book;

import java.util.List;

public interface BookService {
    PageInfo<Book> findAll(Integer page, Integer rows);
}
