package com.example.OnlineBookStore.domain.repository;

import com.example.OnlineBookStore.domain.model.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartRepository {
    @Insert("insert into cart (customer_id, book_id) values (#{customerId}, #{bookId})")
    void addToCart(Integer customerId, Integer bookId);

    @Select("select * from cart inner join books on cart.book_id = books.id where cart.customer_id = #{customerId}")
    List<Cart> findCartByCustomerId(Integer customerId);

    @Delete("delete from cart where customer_id = #{customerId} and book_id = #{bookId}")
    void deleteItemInCart(Integer customerId, Integer bookId);
}
