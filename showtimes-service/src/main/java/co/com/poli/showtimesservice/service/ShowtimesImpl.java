package co.com.poli.showtimesservice.service;

import co.com.poli.showtimesservice.clientFeign.MoviesClient;
import co.com.poli.showtimesservice.persistence.entity.Showtimes;
import co.com.poli.showtimesservice.persistence.repository.ShowtimesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowtimesImpl implements ShowtimesServices {

    private final ShowtimesRepository showtimesRepository;
    private final MoviesClient moviesClient;

    @Override
    public Boolean save(Showtimes showtimes) {
        List<Boolean> validateExist = showtimes.getMovie().stream()
                .map(cd_movie -> {
                    if (moviesClient.findById(cd_movie).getData() == null) {
                        return false;
                    }
                    return true;
                }).collect(Collectors.toList());
        for (Boolean valid :
                validateExist) {
            if (!valid) {
                return false;
            }
        }
        showtimesRepository.save(showtimes);
        return true;
    }

    @Override
    public List<Showtimes> findAll() {
        return showtimesRepository.findAll();
    }

    @Override
    public Showtimes findById(Long id) {
        return showtimesRepository.findById(id).orElse(null);
    }
}
