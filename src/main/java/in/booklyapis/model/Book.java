package in.booklyapis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@Table(name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title should not be null")
    private String title;
    private String genre;
    @NotBlank(message = "Author should not be null")
    private String author;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate publishedDate;
    private int availableCount;
    private int totalCount;
    @CreationTimestamp
    @Column( name = "created_at",nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name ="updated_at")
    private Date updatedAt;
}

