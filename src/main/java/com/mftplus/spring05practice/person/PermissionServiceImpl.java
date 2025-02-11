package com.mftplus.spring05practice.person;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }


    @Override
    public void save(Permission permission) {
        permissionRepository.save(permission);
    }

    @Override
    public void update(Permission permission) {
        permissionRepository.save(permission);
    }

    @Override
    public void delete(Long id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public Permission findById(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }
}
