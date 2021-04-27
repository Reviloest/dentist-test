package com.cgi.dentistapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SearchDTO {
    String dentistName;

    String visitTime;

    String visitTimeHours;

    public SearchDTO() {
    }

    public SearchDTO(String dentistName, String visitTime, String visitTimeHours) {
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