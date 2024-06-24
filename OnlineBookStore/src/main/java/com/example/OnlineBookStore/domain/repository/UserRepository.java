package com.example.OnlineBookStore.domain.repository;

import com.example.OnlineBookStore.domain.model.Order;
import com.example.OnlineBookStore.domain.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {
    @Select("select * from users where username = #{username}")
    Optional<User> findByUsername(String username);

    @Select("select * from users")
    List<User> findAllUserList();

    @Insert("insert into users (username, password, authority) values (#{username}, #{password}, 'USER')")
    void registerUser(User user);

    @Insert("insert into users (username, password, authority) values (#{username}, #{password}, 'ADMIN')")
    void registerAdmin(User user);

    @Select("select * from history inner join books on history.book_id = books.id where history.username = #{username}")
    List<Order> showHistoryByUsername(String username);
}