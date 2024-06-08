package com.example.OnlineBookStore.domain.repository;

import com.example.OnlineBookStore.controller.user.UserRegistrationForm;
import com.example.OnlineBookStore.domain.oath.User;
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

    @Insert("insert into users (username, password) values (#{username}, #{password})")
    void registerUser(User user);
}