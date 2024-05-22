package com.example.OnlineBookStore.domain.repository;

import com.example.OnlineBookStore.domain.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookRepository {
    @Select("select * from books")
    List<Book> findAll();
}
