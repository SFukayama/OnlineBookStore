package com.example.OnlineBookStore.domain.repository;

import com.example.OnlineBookStore.domain.model.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookRepository {
    @Select("select * from books")
    List<Book> findAll();

    @Select("select * from books where id = #{bookId}")
    Book findBookDetailById(Integer bookId);

    @Insert("insert into books (title, author, price, stock) values (#{title}, #{author}, #{price}, #{stock})")
    void registerBook(Book book);

    @Update("update books set id = #{id}, title = #{title}, author = #{author}, price = #{price}, stock = #{stock} where id = #{id};")
    void updateBook(Book book);
}
