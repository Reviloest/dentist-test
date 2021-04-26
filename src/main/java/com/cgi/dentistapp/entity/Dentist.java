package com.cgi.dentistapp.entity;

import javax.persistence.*;

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

    public String getName() {
        return name;
    }

    public long getDentist_id() {
        return dentist_id;
    }
}
