package com.example.OnlineBookStore.application.service;

import com.example.OnlineBookStore.application.dto.OrderDTO;
import com.example.OnlineBookStore.application.dto.UserDTO;
import com.example.OnlineBookStore.controller.management.AdminRegistrationForm;
import com.example.OnlineBookStore.controller.user.UserRegistrationForm;
import com.example.OnlineBookStore.domain.model.User;
import com.example.OnlineBookStore.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserApplicationService {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public List<UserDTO> findAllUserList() {
        List<UserDTO> userList = userService.findAllUserList().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
        return userList.stream()
                .sorted(Comparator.comparing(UserDTO::getUserId))
                .collect(Collectors.toList());
    }

    public void registerUser(UserRegistrationForm userRegistrationForm) {
        User user = modelMapper.map(userRegistrationForm, User.class);
        userService.registerUser(user);
    }

    public void registerAdmin(AdminRegistrationForm adminRegistrationForm) {
        User user = modelMapper.map(adminRegistrationForm, User.class);
        userService.registerAdmin(user);
    }

    public List<OrderDTO> showHistoryByUsername(String username) {
        List<OrderDTO> historyList = userService.showHistoryByUsername(username).stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
        return historyList.stream()
                .sorted(Comparator.comparing(OrderDTO::getDate))
                .collect(Collectors.toList());
    }

    public boolean isUsernameUnique(String username) {
        Optional<User> existingUser = userService.findByUsername(username);
        return !existingUser.isPresent();
    }
}
