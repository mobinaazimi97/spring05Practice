package com.mftplus.spring05practice.role;


import java.util.List;

public interface RoleService {
    void save(Role role);
    void update(Role role);
    void delete(String roleName);
    List<Role> findAll();
    List<Role> findByName(String roleName);
}
