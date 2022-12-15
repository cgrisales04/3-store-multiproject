package co.com.poli.userservice.service;

import co.com.poli.userservice.clientFeign.BookingsClient;
import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{
    private final UserRepository userRepository;
    private final BookingsClient bookingsClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(User user) {
        System.out.println(bookingsClient.findByuserid(user.getId()).getData());
        System.out.println(bookingsClient.findByuserid(user.getId()).getData().toString());
        if (bookingsClient.findByuserid(user.getId()).getData().toString() != "[]"){
            return false;
        }
        userRepository.delete(user);
        return true;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
