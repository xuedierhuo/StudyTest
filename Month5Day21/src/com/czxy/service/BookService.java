package com.czxy.service;

import java.util.List;

import com.czxy.dao.BookMapper;
import com.czxy.domain.Book;
import com.czxy.utils.MyBatisUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

public class BookService {
    //查询所有
	public List<Book> selectAll() {
		 BookMapper mapper = MyBatisUtils.getMapper(BookMapper.class);
		 List<Book> list = mapper.selectAll();
		return list;
	}
    //根据id进行查询
	public Book selectBookById(String id) {
		 BookMapper mapper = MyBatisUtils.getMapper(BookMapper.class);
		 Book book = mapper.selectByPrimaryKey(id);
		return book;
	}
    //更新
	public void updateBook(Book book) {
		BookMapper mapper = MyBatisUtils.getMapper(BookMapper.class);
		mapper.updateByPrimaryKey(book);
		MyBatisUtils.commitAndclose();
	}
  
    //删除
	public void deleteBookById(String id) {
		BookMapper mapper = MyBatisUtils.getMapper(BookMapper.class);
		mapper.deleteByPrimaryKey(id);
		MyBatisUtils.commitAndclose();
		
	}
   //添加
	public void addBook(Book book) {
		BookMapper mapper = MyBatisUtils.getMapper(BookMapper.class);
		mapper.insert(book);
		MyBatisUtils.commitAndclose();
	}

	public List<Book> findProductByManyCondition(Book book) {
		BookMapper mapper = MyBatisUtils.getMapper(BookMapper.class);
		Example example = new Example(Book.class);
		Criteria criteria = example.createCriteria();
		String[] split = book.getName().split("");
		StringBuilder sb = new StringBuilder("%");
		for (String s : split) {
			sb.append(s).append("%");
		}
		criteria.andLike("name",sb.toString());

		if (book.getId()!=null && book.getId().trim().length()!=0){
			criteria.andEqualTo("id",book.getId());
		}

		if (book.getCategory()!=null && book.getCategory().trim().length()!=0){
			criteria.andEqualTo("category",book.getCategory());
		}

		List<Book> books = mapper.selectByExample(example);
		return books;
	}
}
