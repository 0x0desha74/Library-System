package in.booklyapis.controller;

import in.booklyapis.model.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorsController {


    @PostMapping("authors")
    public ResponseEntity<Author> addAuthor(@RequestBody author){
        return new ResponseEntity<>()
    }

}
