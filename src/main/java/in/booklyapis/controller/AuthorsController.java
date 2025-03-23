package in.booklyapis.controller;

import in.booklyapis.dto.AuthorDto;
import in.booklyapis.model.Author;
import in.booklyapis.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("authors")
    public ResponseEntity<List<AuthorDto>> getAuthors(){
        return new ResponseEntity<>(authorService.getAllAuthors(),HttpStatus.OK);
    }


    @PostMapping("authors")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorService.addAuthor(author), HttpStatus.CREATED);
    }

}
