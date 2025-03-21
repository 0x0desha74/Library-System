package in.booklyapis.model;


import jakarta.persistence.*;
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
    private String name;
    private Date bitrhDate;
    private Date deathDate;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
