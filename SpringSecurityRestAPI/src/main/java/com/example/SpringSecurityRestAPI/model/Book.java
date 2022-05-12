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
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "unique_title_constraint", columnNames = "title")
})
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
