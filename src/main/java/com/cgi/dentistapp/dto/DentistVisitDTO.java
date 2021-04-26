package com.cgi.dentistapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeHours() {
        return visitTimeHours;
    }

    public void setVisitTimeHours(String visitTimeHours) {
        this.visitTimeHours = visitTimeHours;
    }
}
