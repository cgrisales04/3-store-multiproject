package co.com.poli.userservice.persistence.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Bookings {
    private Long id;
    private Long userid;
    private Long showtimeid;
    private List<Integer> movies;
}
