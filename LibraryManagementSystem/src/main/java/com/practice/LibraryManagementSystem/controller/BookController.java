package com.practice.LibraryManagementSystem.controller;

import com.practice.LibraryManagementSystem.model.Book;
import com.practice.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService service;

    @GetMapping("/get")
    public ResponseEntity<List<Book>> getAllBooks(){
        return service.getAllBooks();
    }
    @GetMapping("/get/{id}")
    public Book getBook(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return service.save(book);
    }
    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        // Additional logic to ensure you're updating the correct book
        return service.save(book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = service.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }
    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = service.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

//    @GetMapping("/Borrower")
//    public ResponseEntity<List<User>> getListOfUserWhoBorrowedBook(){
//        return service.getListOfUserWhoBorrowedBook();
//    }
}
