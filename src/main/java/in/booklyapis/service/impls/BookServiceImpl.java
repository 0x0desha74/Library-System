package in.booklyapis.service.impls;

import in.booklyapis.model.Book;
import in.booklyapis.repository.BookRepository;
import in.booklyapis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository  bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent())
            return book.get();
        throw new RuntimeException("Book not found");
    }

    @Override
    public Book addBook(Book entity) {
       return bookRepository.save(entity);
    }

    @Override
    public Book updateBook(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
//
//    @Override
//    public List<Book> getBooksByAuthor(String author) {
//        return bookRepository.findByAuthor(author);
//    }

    @Override
    public List<Book> getBooksByKeyword(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }
}
