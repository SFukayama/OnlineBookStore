package com.example.OnlineBookStore.application.service;

import com.example.OnlineBookStore.application.dto.UserDTO;
import com.example.OnlineBookStore.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserApplicationService {

    private final UserService userService;

    public List<UserDTO> findAllUserList() {
        return userService.findAllUserList().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }
}
