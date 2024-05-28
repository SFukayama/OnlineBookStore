package com.example.OnlineBookStore.application.service;

import com.example.OnlineBookStore.application.dto.BookDTO;
import com.example.OnlineBookStore.controller.management.BookRegistrationForm;
import com.example.OnlineBookStore.domain.model.Book;
import com.example.OnlineBookStore.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookApplicationService {

    private final BookService bookService;
    private final ModelMapper modelMapper;

    public List<BookDTO> findAll() {
        return bookService.findAll().stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    public BookDTO findBookDetailById(Integer bookId) {
        return new BookDTO(bookService.findBookDetailById(bookId));
    }

    public void registerBook(BookRegistrationForm bookRegistrationForm) {
        Book book = modelMapper.map(bookRegistrationForm, Book.class);
        bookService.registerBook(book);
    }

    public void updateBookById(BookRegistrationForm bookRegistrationForm) {
        Book book = modelMapper.map(bookRegistrationForm, Book.class);
        bookService.updateBook(book);
    }

    public void deleteBookById(Integer bookId) {
        bookService.deleteBook(bookId);
    }

    public List<BookDTO> findBooksByAuthor(String author) {
        return bookService.findBooksByAuthor(author).stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }
}
