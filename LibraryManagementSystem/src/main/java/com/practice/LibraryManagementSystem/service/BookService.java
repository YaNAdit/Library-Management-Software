package com.practice.LibraryManagementSystem.service;

import com.practice.LibraryManagementSystem.dao.BookDao;
import com.practice.LibraryManagementSystem.dao.UserDao;
import com.practice.LibraryManagementSystem.model.Book;
import com.practice.LibraryManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookDao bookRepo;

    @Autowired
    UserDao userRepo;

    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookRepo.findAll(), HttpStatus.OK);
    }

    public Book findById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return bookRepo.save(book);
    }

    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    public Book borrowBook(Long bookId, Long userId) {
        Book book = findById(bookId);
        User user = userRepo.findById(userId).orElse(null);

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        // Handle errors (e.g., book not found, book already borrowed, user not found)
        return null;
    }
    public Book returnBook(Long bookId) {
        Book book = findById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        // Handle errors (e.g., book not found, book not borrowed)
        return null;
    }
}
