package co.com.poli.bookingsservice.persistence.entity;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String title;
    private String director;
    private String rating;
}
