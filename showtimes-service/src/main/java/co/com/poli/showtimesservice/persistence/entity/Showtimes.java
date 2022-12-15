package co.com.poli.showtimesservice.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "showtimes")
public class Showtimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true)
    private Long id;
    @NotNull(message = "La fecha no debe estar vacia")
    @Column(name = "date")
    private Date date;
    @Column(name = "movie")
    @ElementCollection
    private List<Long> movie;
}
