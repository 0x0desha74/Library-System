package in.booklyapis.service;

import in.booklyapis.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book getBook(Long id);
    Book addBook(Book entity);
    Book updateBook(Book entity);
    void deleteBook(Long id);
    List<Book> getBooksByTitle(String name);
    List<Book> getBooksByGenre(String genre);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByKeyword(String keyword);

}
