package com.mftplus.spring05practice.person;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User save(User user);

    User update(User user);

    void delete(User user);

    List<User> findAll();

    List<User> saveAll(List<User> users);

    User findByUsername(String username);

    List<User> findByPassword(String password);

    boolean existsByUsername(String username);

    Page<User> getAllUser(Pageable pageable);

}
