package com.example.SpringSecurityRestAPI.controller;


import com.example.SpringSecurityRestAPI.exception.ApplicationException;
import com.example.SpringSecurityRestAPI.exception.BookNotFoundException;
import com.example.SpringSecurityRestAPI.model.Book;
import com.example.SpringSecurityRestAPI.service.BookService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private static Logger log = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Collection<Book>> findAll() {
        log.info("BookResourceImpl - findAll");
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")// cai nay do get tren nen duoi cung phai dang nhap theo
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        log.info("BookResourceImpl - findById");
        Optional<Book> book = bookService.findById(id);
        if(!book.isPresent()) {
            throw new BookNotFoundException("Book not found");
        }
        return new ResponseEntity<>(book.get(), HttpStatus.OK);
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Book> save(@RequestBody  Book book) {
        log.info("BookResourceImpl - save");
        if(book.getId() != null) {
            throw new ApplicationException("Book ID found, ID is not required for save the data");
        }
        return new ResponseEntity<>(bookService.saveOrUpdate(book), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        log.info("BookResourceImpl - update");
        if(book.getId() == null) {
            throw new ApplicationException("Book ID not found, ID is required for update the data");
        }
        return new ResponseEntity<>(bookService.saveOrUpdate(book), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        log.info("BookResourceImpl - deleteById");
        Optional<Book> book = bookService.findById(id);
        if(!book.isPresent()) {// neu bien book khong co gia tri
            throw new BookNotFoundException("Book not found");
        }
        return new ResponseEntity<>(bookService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping("/invalid")
    public ResponseEntity<String> invalid() {
        log.info("BookResourceImpl - invalid");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("message", "something is missing, please check everything before sending the request!!!");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }


}
