package com.mftplus.spring05practice.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    List<Role> findByName(String roleName);
}
