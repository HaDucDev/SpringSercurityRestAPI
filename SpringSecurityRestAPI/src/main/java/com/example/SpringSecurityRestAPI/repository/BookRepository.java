package com.example.SpringSecurityRestAPI.repository;

import com.example.SpringSecurityRestAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
