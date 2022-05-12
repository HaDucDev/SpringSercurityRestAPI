package com.example.SpringSecurityRestAPI.service;

import com.example.SpringSecurityRestAPI.model.Book;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookService {

    Collection<Book> findAll();

    Optional<Book> findById(Long id);

    Book saveOrUpdate(Book user);

    String deleteById(Long id);
}
