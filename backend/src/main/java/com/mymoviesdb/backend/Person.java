package com.mymoviesdb.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column
    private String fname;

    @NotBlank
    @Column
    private String lname;

    @NotBlank
    @Email
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(min = 8)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy="person",cascade = CascadeType.ALL)
    private List<Favourite> favourites;

    public Person() {
    }

    public Person(String fname, String lname, String username, String password, List<Favourite> favourites) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.favourites = favourites;
    }

    public Long getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fname='" + fname +'\'' +
                ", lname='" + lname +'\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public void add(Favourite favourite) {

        if (favourites == null) {
            favourites = new ArrayList<>();
        }

        favourites.add(favourite);

        favourite.setPerson(this);
    }

}