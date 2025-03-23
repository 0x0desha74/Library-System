package in.booklyapis.service;

import in.booklyapis.dto.AuthorDto;
import in.booklyapis.model.Author;

import java.util.List;

public interface AuthorService {
    Author addAuthor(Author entity);
    Author updateAuthor(Author entity);
    Author getAuthor(Long id);
    List<AuthorDto> getAllAuthors();
    void deleteAuthor(Long id);
}
