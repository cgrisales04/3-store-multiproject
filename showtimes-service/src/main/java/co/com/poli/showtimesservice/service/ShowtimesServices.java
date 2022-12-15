package co.com.poli.showtimesservice.service;

import co.com.poli.showtimesservice.persistence.entity.Showtimes;

import java.util.List;

public interface ShowtimesServices {
    Boolean save(Showtimes showtimes);

    List<Showtimes> findAll();

    Showtimes findById(Long id);
}
