package in.booklyapis.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "authors" )
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name should not be null")
    private String name;
    private Date birthDate;
    private Date deathDate;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
