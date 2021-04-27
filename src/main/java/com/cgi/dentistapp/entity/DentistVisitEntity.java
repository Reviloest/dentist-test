package com.cgi.dentistapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
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

    @NotNull
    private String endHour;

    public DentistVisitEntity() {}

    public DentistVisitEntity(Dentist dentist, Date date, String startHour) {
        this.dentist = dentist;
        this.date = date;
        this.dentistName = dentist.name;
        this.startHour = startHour;
        if (startHour.charAt(1) == '9') {
            String first = startHour.substring(0,1);
            int firstVal = Integer.parseInt(first) + 1;
            String firstAfter = String.valueOf(firstVal);
            this.endHour = firstAfter + "0";
        } else {
            String first = startHour.substring(0,1);
            String second = startHour.substring(1,2);
            int secondVal = Integer.parseInt(second) + 1;
            String secondAfter = String.valueOf(secondVal);
            this.endHour = first + secondAfter;
        }
    }

    public String getDate() {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }
}
