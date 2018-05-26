package com.xderhuo.mapper;

import com.xderhuo.domain.Loan;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface LoanMapper extends Mapper<Loan> {

    @Select("select * from loan where uid = #{uid}")
    @Results({
            @Result(property = "lid", column = "lid"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "loantime", column = "loanTime"),
            @Result(property = "bookid", column = "bookid"),
            @Result(property = "loannumber", column = "loannumber"),
            @Result(property = "book", one = @One(select = "com.xderhuo.mapper.BookMapper.findBookById") ,column = "bookid")
    })
    List<Loan> findLoanByUid(String uid);
}