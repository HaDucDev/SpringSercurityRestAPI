package com.example.SpringSecurityRestAPI.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @OneToMany(targetEntity =  User.class, mappedBy = "role",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<User> users;

    public Role(Long id, String name){
        this.id=id;
        this.name=name;
    }

}
