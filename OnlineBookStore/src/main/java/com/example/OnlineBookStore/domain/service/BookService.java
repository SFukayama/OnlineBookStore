package com.example.OnlineBookStore.domain.service;

import com.example.OnlineBookStore.application.dto.BookDTO;
import com.example.OnlineBookStore.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookDTO> findAll() {
        return bookRepository.findAll();
    }
}
