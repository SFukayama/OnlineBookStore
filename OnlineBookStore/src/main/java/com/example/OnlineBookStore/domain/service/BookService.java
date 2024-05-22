package com.example.OnlineBookStore.domain.service;

import com.example.OnlineBookStore.application.dto.BookDTO;
import com.example.OnlineBookStore.domain.model.Book;
import com.example.OnlineBookStore.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findBookDetailById(Integer bookId) {
        return bookRepository.findBookDetailById(bookId);
    }
}
