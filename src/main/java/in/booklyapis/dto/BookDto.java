package in.booklyapis.dto;

import lombok.*;
@Getter
@Setter
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private int availableCount;
    private int totalCount;
}
