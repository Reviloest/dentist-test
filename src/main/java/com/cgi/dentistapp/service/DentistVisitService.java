package com.cgi.dentistapp.service;

import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.DentistRepository;
import com.cgi.dentistapp.repository.DentistVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DentistVisitService {

    private final DentistVisitRepository dentistVisitRepository;
    private final DentistRepository dentistRepository;

    @Autowired
    public DentistVisitService(DentistVisitRepository dentistVisitRepository, DentistRepository dentistRepository) {
        this.dentistVisitRepository = dentistVisitRepository;
        this.dentistRepository = dentistRepository;
    }

    public boolean addVisit(String dentistName, String visitTime, String visitTimeHours) throws ParseException {
        Dentist dentist = dentistRepository.findAll().stream().filter(x -> x.getName().equals(dentistName)).collect(Collectors.toList()).get(0);
        String[] date = visitTime.split("-");
        String convertedDate = "";
        convertedDate += date[2] + "-";
        convertedDate += date[1] + "-";
        convertedDate += date[0];
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = format.parse(convertedDate);
        /*for (DentistVisitEntity e: dentistVisitRepository.findAll()) {
            System.out.println(e.getDentistName().equals(dentistName));
            System.out.println(format.parse(e.getDate()).equals(startDate));
            System.out.println(e.getStartHour().equals(visitTimeHours));
            System.out.println("1: " + e.getDentistName() + ", 2: " + dentistName);
            System.out.println("1: " + format.parse(e.getDate()) + ", 2: " + startDate.toString());
            System.out.println("1: " + e.getStartHour() + ", 2: " + visitTimeHours);
        }*/
            List<DentistVisitEntity> dentistVisitEntityList = dentistVisitRepository.findAll()
                    .stream()
                    .filter(x -> {
                        try {
                            return x.getDentistName().equals(dentistName) && format.parse(x.getDate()).equals(startDate)
                                    && x.getStartHour().equals(visitTimeHours);
                        } catch (ParseException e) {
                            e.printStackTrace();
                            return false;
                        }
                    })
                    .collect(Collectors.toList());
            if (dentistVisitEntityList.size() == 0) {
                DentistVisitEntity dentistVisitEntity = new DentistVisitEntity(dentist, startDate, visitTimeHours);
                dentistVisitRepository.save(dentistVisitEntity);
                return true;
            }
            return false;
        }
    }
