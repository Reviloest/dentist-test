package com.cgi.dentistapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dentist_id;

    @Column(name = "name")
    String name;

    public Dentist() {}

    public Dentist(String name) {
        this.name = name;
    }
}
