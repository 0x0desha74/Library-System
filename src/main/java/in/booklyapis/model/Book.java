package in.booklyapis.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title should not be null")
    private String title;
    private String genre;
    @NotBlank(message = "Author should not be null")
    private String author;
    @NotBlank(message = "Publish Date should not be null")
    private LocalDate publishedDate;
    private int availableCount;
    private int totalCount;
}
