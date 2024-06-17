package com.example.OnlineBookStore.domain.repository;

import com.example.OnlineBookStore.domain.model.Cart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartRepository {
    @Insert("insert into cart (username, book_id) values (#{username}, #{bookId})")
    void addToCart(String username, Integer bookId);

    @Select("select * from cart inner join books on cart.book_id = books.id where cart.username = #{username}")
    List<Cart> findCartByUsername(String username);

    @Delete("delete from cart where cart_id = #{cartId}")
    void deleteItemInCart(Integer cartId);

    @Delete("delete from cart where username = #{username}")
    void deleteCartByUsername(String username);

//    @Update("") void reduceStock(String username);
}
