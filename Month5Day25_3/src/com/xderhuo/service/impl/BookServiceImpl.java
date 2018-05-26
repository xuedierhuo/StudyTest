package com.xderhuo.service.impl;

import com.xderhuo.domain.Book;
import com.xderhuo.mapper.BookMapper;
import com.xderhuo.service.BookService;
import com.xderhuo.utils.MyBatisUtils;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> findAll() {
        BookMapper bookMapper = MyBatisUtils.getMapper(BookMapper.class);
        List<Book> books = bookMapper.selectAll();
        MyBatisUtils.close();
        return books;
    }

    /**
     * 指定id进行查询
     * @param bookid
     * @return
     */
    @Override
    public Book findBookById(String bookid) {
        BookMapper bookMapper = MyBatisUtils.getMapper(BookMapper.class);
        Book book = new Book();
        book.setBookid(bookid);
        Book b = bookMapper.selectByPrimaryKey(book);
        MyBatisUtils.close();
        return b;
    }
}
