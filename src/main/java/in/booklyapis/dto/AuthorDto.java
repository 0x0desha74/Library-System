package in.booklyapis.dto;

import in.booklyapis.model.Book;
import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class AuthorDto {
    private Long id;
    private String name;
    private Date birthDate;
    private Date deathDate;

}
