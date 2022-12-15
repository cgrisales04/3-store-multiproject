package co.com.poli.bookingsservice.service;

import co.com.poli.bookingsservice.clientFeign.MoviesClient;
import co.com.poli.bookingsservice.clientFeign.ShowtimesClient;
import co.com.poli.bookingsservice.clientFeign.UserClient;
import co.com.poli.bookingsservice.persistence.entity.Bookings;
import co.com.poli.bookingsservice.persistence.repository.BookingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsServices {
    private final BookingsRepository bookingsRepository;
    private final ShowtimesClient showtimesClient;
    private final MoviesClient moviesClient;
    private final UserClient userClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean save(Bookings bookings) {
        if (userClient.findById(bookings.getUserid()).getData() == null ||
                showtimesClient.findById(bookings.getShowtimeid()).getData() == null) {
            return false;
        }
        List<Boolean> validateExist = bookings.getMovie().stream()
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
        bookingsRepository.save(bookings);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Bookings bookings) {
        bookingsRepository.delete(bookings);
    }

    @Override
    public List<Bookings> findAll() {
        return bookingsRepository.findAll();
    }

    @Override
    public Bookings findById(Long id) {
        return bookingsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bookings> findByuserid(Long userid) {
        return bookingsRepository.findByuserid(userid);
    }

}
