package in.booklyapis.controller;

import in.booklyapis.model.Book;
import in.booklyapis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){

        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.CREATED);

    }
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book model){
       return new ResponseEntity<>(bookService.addBook(model), HttpStatus.CREATED);
    }
}
