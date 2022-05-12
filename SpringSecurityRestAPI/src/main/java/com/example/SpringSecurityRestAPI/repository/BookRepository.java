package com.example.SpringSecurityRestAPI.repository;

import com.example.SpringSecurityRestAPI.model.Book;
import com.example.SpringSecurityRestAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("FROM Book WHERE title=:title")
    Book findByTitle(@Param("title") String title);
}
