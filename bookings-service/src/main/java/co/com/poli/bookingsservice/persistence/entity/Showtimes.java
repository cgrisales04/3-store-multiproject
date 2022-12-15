package co.com.poli.bookingsservice.persistence.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Showtimes {
    private Long id;
    private Date date;
    private List<Integer> movies;
}
