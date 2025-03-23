package in.booklyapis.controller;

import in.booklyapis.model.Book;
import in.booklyapis.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    private BookService bookService;
    @Operation(summary = "Get all users", description = "Returns a list of all users.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(@RequestParam String Keyword){
        if(Keyword == null)
            return new ResponseEntity<>(bookService.getBooks(), HttpStatus.CREATED);
        return new ResponseEntity<>(bookService.getBooksByKeyword(Keyword),HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @GetMapping("/books/filterByTitle")
    public ResponseEntity<List<Book>>  search(@RequestParam String title){
        return new ResponseEntity<>(bookService.getBooksByTitle(title),HttpStatus.OK);
    }


    @GetMapping("/books/filterByGenre")
    public ResponseEntity<List<Book>>  searchByGenre(@RequestParam String genre){
        return new ResponseEntity<>(bookService.getBooksByGenre(genre),HttpStatus.OK);
    }

    @GetMapping("/books/filterByAuthor")
    public ResponseEntity<List<Book>>  searchByAuthor(@RequestParam String author){
        return new ResponseEntity<>(bookService.getBooksByAuthorName(author),HttpStatus.OK);
    }

    @GetMapping("/books/filterByKeyword")
    public ResponseEntity<List<Book>>  searchByKeyword(@RequestParam String keyword){
        return new ResponseEntity<>(bookService.getBooksByKeyword(keyword),HttpStatus.OK);
    }


    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book model){
        return new ResponseEntity<>(bookService.addBook(model), HttpStatus.CREATED);
    }

    @PutMapping("/books")
    public ResponseEntity<Book> editBook(@RequestBody @Valid Book model){
        return new ResponseEntity<>(bookService.updateBook(model), HttpStatus.OK);
    }

    @DeleteMapping("/books")
    public ResponseEntity<HttpStatus> deleteBook(@RequestParam Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }



}
