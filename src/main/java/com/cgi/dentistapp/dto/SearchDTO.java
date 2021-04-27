package com.cgi.dentistapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {
    String dentistName = null;

    String visitTime = null;

    String visitTimeHours = null;

    public SearchDTO() {
    }

    public SearchDTO(String dentistName, String visitTime, String visitTimeHours) {
        this.dentistName = dentistName;
        this.visitTime = visitTime;
        this.visitTimeHours = visitTimeHours;
    }
}