package com.example.OnlineBookStore.domain.service;

import com.example.OnlineBookStore.domain.model.Book;
import com.example.OnlineBookStore.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public void registerBook(Book book) {
        bookRepository.registerBook(book);
    }

    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    public void deleteBook(Integer bookId) {
        bookRepository.deleteBook(bookId);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author);
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }
}
