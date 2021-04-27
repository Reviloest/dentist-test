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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    public Date dateConvert(String visitTime) throws ParseException {
        String[] date = visitTime.split("-");
        String convertedDate = "";
        convertedDate += date[2] + "-";
        convertedDate += date[1] + "-";
        convertedDate += date[0];
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.parse(convertedDate);
    }

    public List<DentistVisitEntity> filterResult(String dentistName, String visitTimeHours, Date startDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return dentistVisitRepository.findAll()
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
    }

    public boolean changeVisit(String dentistName, String visitTime, String visitTimeHours, Long id) throws ParseException {
        Date date = dateConvert(visitTime);
        List<DentistVisitEntity> dentistVisitEntityList = filterResult(dentistName, visitTimeHours, date);
        Dentist dentist = dentistRepository.findAll().stream().filter(x -> x.getName().equals(dentistName)).collect(Collectors.toList()).get(0);
        if (dentistVisitEntityList.size() == 0) {
            Optional<DentistVisitEntity> dentistVisitEntityOld = dentistVisitRepository.findAll().stream().filter(x -> x.getId().equals(id)).findFirst();
            if (dentistVisitEntityOld.isPresent()) {
                DentistVisitEntity dentistVisitEntityOldObject = dentistVisitEntityOld.get();
                dentistVisitRepository.delete(dentistVisitEntityOldObject);
                DentistVisitEntity newDentistVisit = new DentistVisitEntity(dentist, date, visitTimeHours);
                dentistVisitRepository.save(newDentistVisit);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean addVisit(String dentistName, String visitTime, String visitTimeHours) throws ParseException {
        Date date = dateConvert(visitTime);
        List<DentistVisitEntity> dentistVisitEntityList = filterResult(dentistName, visitTimeHours, date);
        Dentist dentist = dentistRepository.findAll().stream().filter(x -> x.getName().equals(dentistName)).collect(Collectors.toList()).get(0);
        if (dentistVisitEntityList.size() == 0) {
            DentistVisitEntity dentistVisitEntity = new DentistVisitEntity(dentist, date, visitTimeHours);
            dentistVisitRepository.save(dentistVisitEntity);
            return true;
        }
        return false;
    }

    public List<DentistVisitEntity> searchByParameters(String dentistName, String startDate, String startTime) {
        System.out.println("name: " + dentistName);
        System.out.println(startDate);
        System.out.println(startTime);
        if (dentistName != null && startDate != null && startTime != null) {
            String[] arrangedDate = startDate.split("-");
            String startDateConv = arrangedDate[2] + "-" + arrangedDate[1] + "-" + arrangedDate[0];
            return dentistVisitRepository
                    .findAll()
                    .stream()
                    .filter(x -> x.getDentistName().equals(dentistName)
                            && x.getDate().equals(startDateConv)
                            && x.getStartHour().equals(startTime))
                    .collect(Collectors.toList());
        } else if (dentistName != null && startDate == null && startTime == null) {
            return dentistVisitRepository
                    .findAll()
                    .stream()
                    .filter(x -> x.getDentistName().equals(dentistName))
                    .collect(Collectors.toList());
        } else if (dentistName == null && startDate != null && startTime == null) {
            String[] arrangedDate = startDate.split("-");
            String startDateConv = arrangedDate[2] + "-" + arrangedDate[1] + "-" + arrangedDate[0];
            return dentistVisitRepository
                    .findAll()
                    .stream()
                    .filter(x -> x.getDate().equals(startDateConv))
                    .collect(Collectors.toList());
        } else if (dentistName == null && startDate == null && startTime != null) {
            System.out.println("YES");
            System.out.println("START: " + startTime);
            return dentistVisitRepository
                    .findAll()
                    .stream()
                    .filter(x -> x.getStartHour().equals(startTime))
                    .collect(Collectors.toList());
        } else if (dentistName != null && startDate != null && startTime == null) {
            String[] arrangedDate = startDate.split("-");
            String startDateConv = arrangedDate[2] + "-" + arrangedDate[1] + "-" + arrangedDate[0];
            return dentistVisitRepository
                    .findAll()
                    .stream()
                    .filter(x -> x.getDate().equals(startDateConv) && x.getDentistName().equals(dentistName))
                    .collect(Collectors.toList());
        } else if (dentistName != null && startDate == null && startTime != null) {
            return dentistVisitRepository
                    .findAll()
                    .stream()
                    .filter(x -> x.getStartHour().equals(startTime) && x.getDentistName().equals(dentistName))
                    .collect(Collectors.toList());
        } else if (dentistName == null && startDate != null && startTime != null) {
            String[] arrangedDate = startDate.split("-");
            String startDateConv = arrangedDate[2] + "-" + arrangedDate[1] + "-" + arrangedDate[0];
            return dentistVisitRepository
                    .findAll()
                    .stream()
                    .filter(x -> x.getDate().equals(startDateConv) && x.getStartHour().equals(startTime))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<DentistVisitEntity> findAll() {
        return dentistVisitRepository.findAll();
    }

    public void delete(Long id) {
        dentistVisitRepository.delete(id);
    }

    public DentistVisitEntity findVisitById(Long id) {
        Optional<DentistVisitEntity> dentistVisitEntity = dentistVisitRepository
                .findAll()
                .stream()
                .filter(x -> x.getId()
                        .equals(id))
                .collect(Collectors.toList())
                .stream()
                .findFirst();
        return dentistVisitEntity.orElse(null);
    }
}
