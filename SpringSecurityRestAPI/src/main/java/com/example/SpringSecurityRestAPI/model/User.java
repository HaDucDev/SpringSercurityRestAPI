package com.example.SpringSecurityRestAPI.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private  String email;

    @NotNull
    private  String mobile;

    @NotNull
    private  String password;

    @ManyToOne
    @JoinColumn(name = "role_id")// tao khoa ngoai role_id o bang user. noi vs khoa chinh o bang role
    private Role role;
    // 1 quyen co nhieu nguoi va 1 nguoi chi co mot quyen thoi


}
