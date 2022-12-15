package co.com.poli.bookingsservice.service;

import co.com.poli.bookingsservice.persistence.entity.Bookings;

import java.util.List;

public interface BookingsServices {
    Boolean save(Bookings bookings);

    void delete(Bookings bookings);

    List<Bookings> findAll();

    Bookings findById(Long id);

    List<Bookings> findByuserid(Long userid);
}
