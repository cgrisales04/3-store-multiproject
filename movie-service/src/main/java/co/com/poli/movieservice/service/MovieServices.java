package co.com.poli.movieservice.service;

import co.com.poli.movieservice.persistence.entity.Movie;

import java.util.List;

public interface MovieServices {
    void save(Movie movie);
    void delete(Long id);
    List<Movie> findAll();
    Movie findById(Long id);
}
