package com.cgi.dentistapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "dentist_visits")
public class DentistVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @NotNull
    private Date date;

    @NotNull
    private String dentistName;

    @NotNull
    private String startHour;

    public DentistVisitEntity() {}

    public DentistVisitEntity(Dentist dentist, Date date, String startHour) {
        this.dentist = dentist;
        this.date = date;
        this.dentistName = dentist.name;
        this.startHour = startHour;
    }

    public String getDate() {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }

    public Date getDateNoFormating() {
        return date;
    }

    public String getStartHour() {
        return startHour;
    }

    public String getDentistName() {
        return dentistName;
    }
}
