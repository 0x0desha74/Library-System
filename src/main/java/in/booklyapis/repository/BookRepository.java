package in.booklyapis.repository;

import in.booklyapis.dto.BookDto;
import in.booklyapis.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitle(String title);
   List<Book> findByAuthorName(String author);
    List<Book> findByGenre (String genre);
    List<BookDto> findByTitleContaining(String keyword);

}
