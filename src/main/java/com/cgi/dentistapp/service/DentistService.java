package com.cgi.dentistapp.service;

import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DentistService {

    private final DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public void addDentist(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Dentist dentist: dentistRepository.findAll()) {
            names.add(dentist.getName());
        }
        return names;
    }
}
