package com.cgi.dentistapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DentistVisitDTO {

    @NotNull
    @Size(min = 1, max = 50)
    String dentistName;

    @NotNull
    @Size(min = 1, max = 50)
    String visitTime;

    @NotNull
    @Size(min = 1, max = 50)
    String visitTimeHours;

    public DentistVisitDTO() {
    }

    public DentistVisitDTO(String dentistName, String visitTime, String visitTimeHours) {
        this.dentistName = dentistName;
        this.visitTime = visitTime;
        this.visitTimeHours = visitTimeHours;
    }
}
