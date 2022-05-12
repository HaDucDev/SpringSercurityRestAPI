package com.example.SpringSecurityRestAPI.service;

import com.example.SpringSecurityRestAPI.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Collection<User> findAll();

    Optional<User> findById(Long id);

    User saveOrUpdate(User user);

    String deleteById(Long id);
}
