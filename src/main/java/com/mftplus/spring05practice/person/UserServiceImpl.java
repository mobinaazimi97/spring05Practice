package com.mftplus.spring05practice.person;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User save(User user) {
//        return userRepository.save(user);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

//    @Override
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }

    @Override
    public List<User> findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

    @Override
    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
