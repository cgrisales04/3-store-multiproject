package co.com.poli.userservice.service;

import co.com.poli.userservice.persistence.entity.User;

import java.util.List;

public interface UserServices {
    void save(User user);
    Boolean delete(User user);
    List<User> findAll();
    User findById(Long id);
}
