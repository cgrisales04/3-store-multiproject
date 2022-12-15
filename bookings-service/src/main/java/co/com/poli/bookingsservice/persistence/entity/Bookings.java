package co.com.poli.bookingsservice.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="bookings")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,unique = true)
    private Long id;
    @NotNull(message = "El usuario no debe ser nulo")
    @Column(name="userid")
    private Long userid;
    @NotNull(message = "El showtimeid no debe ser nulo")
    @Column(name="showtimeid")
    private Long showtimeid;
    @Column(name = "movie")
    @ElementCollection
    private List<Long> movie;
}
