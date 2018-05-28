package com.xderhuo.service;

import com.xderhuo.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findBookById(String bookid);
}
