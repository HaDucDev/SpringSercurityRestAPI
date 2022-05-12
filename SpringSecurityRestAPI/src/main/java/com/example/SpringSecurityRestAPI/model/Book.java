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
    private String title;// chu de

    @NotNull
    private String author;// tac gia

    @NotNull
    private String coverPhotoURL;// link anh

    @NotNull
    private Long isbnNumber;// sl

    @NotNull
    private Double price;

    @NotNull
    private String language;

}
