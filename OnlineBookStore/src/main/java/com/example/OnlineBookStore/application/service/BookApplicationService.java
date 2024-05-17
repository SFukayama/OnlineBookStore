package com.example.OnlineBookStore.application.service;

import com.example.OnlineBookStore.application.dto.BookDTO;
import com.example.OnlineBookStore.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookApplicationService {

    private final BookService bookService;

    public List<BookDTO> findAll() {
        return bookService.findAll();
    }
}
