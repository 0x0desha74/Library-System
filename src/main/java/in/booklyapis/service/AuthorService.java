package in.booklyapis.service;

import in.booklyapis.model.Author;

import java.util.List;

public interface AuthorService {
    Author addAuthor(Author entity);
    Author updateAuthor(Author entity);
    Author getAuthor(Long id);
    List<Author> getAuthors();
    void deleteAuthor(Long id);
}
