package com.example.OnlineBookStore.domain.repository;

import com.example.OnlineBookStore.domain.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookRepository {
    @Select("select * from books")
    List<Book> findAll();

    @Select("select * from books where id = #{bookId}")
    Book findBookDetailById(Integer bookId);

    @Insert("insert into books (title, author, price, stock) values (#{title}, #{author}, #{price}, #{stock})")
    void registerBook(Book book);

    @Update("update books set id = #{id}, title = #{title}, author = #{author}, price = #{price}, stock = #{stock} where id = #{id}")
    void updateBook(Book book);

    @Delete("delete from books where id = #{bookId}")
    void deleteBook(Integer bookId);

    @Select("select * from books where author = #{author}")
    List<Book> findBooksByAuthor(String author);
}
