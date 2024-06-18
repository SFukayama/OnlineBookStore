package com.example.OnlineBookStore.domain.service;

import com.example.OnlineBookStore.domain.model.Book;
import com.example.OnlineBookStore.domain.oath.User;
import com.example.OnlineBookStore.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllUserList() {
        return userRepository.findAllUserList();
    }

    public void registerUser(User user) {
        userRepository.registerUser(user);
    }

    public void registerAdmin(User user) {
        userRepository.registerAdmin(user);
    }

    public List<Book> showHistoryByUsername(String username) {
        return userRepository.showHistoryByUsername(username);
    }
}
