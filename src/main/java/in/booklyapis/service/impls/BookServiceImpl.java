package in.booklyapis.service.impls;

import in.booklyapis.dto.BookDto;
import in.booklyapis.model.Book;
import in.booklyapis.repository.BookRepository;
import in.booklyapis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository  bookRepository;

    @Override
    public List<BookDto> getBooks() {
        var books = bookRepository.findAll();
        List<BookDto> booksDto = new ArrayList<>();
        books.forEach(b->{
            BookDto bDto = new BookDto();
            bDto.setId(b.getId());
            bDto.setAuthor(b.getAuthor().getName());
            bDto.setGenre(b.getGenre());
            bDto.setTitle(b.getTitle());
            bDto.setAvailableCount(b.getAvailableCount());
            bDto.setTotalCount(b.getTotalCount());
            booksDto.add(bDto);
        });
        return booksDto;
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

    @Override
    public List<Book> getBooksByAuthorName(String author) {
        return bookRepository.findByAuthorName(author);
    }

    @Override
    public List<BookDto> getBooksByKeyword(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }
}
