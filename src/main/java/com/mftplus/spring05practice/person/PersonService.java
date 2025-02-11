package com.mftplus.spring05practice.person;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    Person save(Person person);

    Person update(Person person);

    void delete(Long id);

    Person findById(Long id);

    List<Person> findAll();

}
