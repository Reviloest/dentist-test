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

    public boolean addVisit(String dentistName, String visitTime, String visitTimeHours) throws ParseException {
        Dentist dentist = dentistRepository.findAll().stream().filter(x -> x.getName().equals(dentistName)).collect(Collectors.toList()).get(0);
        String[] date = visitTime.split("-");
        String convertedDate = "";
        convertedDate += date[2] + "-";
        convertedDate += date[1] + "-";
        convertedDate += date[0];
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = format.parse(convertedDate);
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

    public Dentist findDentistById(Long id) {
        Optional<Long> dentistId = dentistVisitRepository
                .findAll()
                .stream()
                .map(DentistVisitEntity::getDentistId)
                .filter(xDentistId -> xDentistId.equals(id))
                .collect(Collectors.toList()).stream().findAny();
        if (dentistId.isPresent()) {
            Optional<Dentist> dentist = dentistRepository
                    .findAll()
                    .stream()
                    .filter(x -> x.getDentist_id()
                            .equals(dentistId.get())).collect(Collectors.toList())
                    .stream()
                    .findFirst();
            return dentist.orElse(null);
        }
        return null;
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
