package com.xderhuo.mapper;

import com.xderhuo.domain.Book;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookMapper extends Mapper<Book> {
    @Select("select * from book where bookid=#{bookid}")
    Book findBookById(@Param("bookid") String bookid);
}