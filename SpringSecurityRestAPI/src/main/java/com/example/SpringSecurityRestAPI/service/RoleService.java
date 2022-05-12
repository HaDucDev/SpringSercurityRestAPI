package com.example.SpringSecurityRestAPI.service;

import com.example.SpringSecurityRestAPI.model.Role;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    Collection<Role> findAll();

    Optional<Role> findById(Long id);

    Role saveOrUpdate(Role role);

    String deleteById(Long id);
}
