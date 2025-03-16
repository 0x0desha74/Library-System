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
}
