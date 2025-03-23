package in.booklyapis.service.impls;

import in.booklyapis.model.Author;
import in.booklyapis.repository.AuthorRepository;
import in.booklyapis.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public Author addAuthor(Author entity) {
        return authorRepository.save(entity);
    }

    @Override
    public Author updateAuthor(Author entity) {
        return authorRepository.save(entity);
    }

    @Override
    public Author getAuthor(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
