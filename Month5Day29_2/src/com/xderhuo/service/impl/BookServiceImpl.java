package com.xderhuo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.Book;
import com.xderhuo.mapper.BookMapper;
import com.xderhuo.service.BookService;
import com.xderhuo.utils.MyBatisUtils;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public PageInfo<Book> findAll(Integer page, Integer rows) {
        BookMapper bookMapper = MyBatisUtils.getMapper(BookMapper.class);
        PageHelper.startPage(page, rows);
        List<Book> books = bookMapper.selectAll();
        return new PageInfo<>(books);
    }
}
