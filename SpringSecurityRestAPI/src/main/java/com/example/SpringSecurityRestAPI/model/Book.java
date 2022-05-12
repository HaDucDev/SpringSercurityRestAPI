package com.example.SpringSecurityRestAPI.model;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String coverPhotoURL;

    @NotNull
    private Long isbnNumber;

    @NotNull
    private Double price;

    @NotNull
    private String language;

}
