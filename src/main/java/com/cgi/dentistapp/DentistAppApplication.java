package com.cgi.dentistapp;

import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.DentistRepository;
import com.cgi.dentistapp.repository.DentistVisitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class DentistAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(DentistAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(DentistRepository repository, DentistVisitRepository dentistVisitRepository) {
        return args -> {
            Dentist dentist1 = new Dentist("Kuusk");
            Dentist dentist2 = new Dentist("Kullerkupp");
            Dentist dentist3 = new Dentist("Kuldsaar");
            repository.save(dentist1);
            repository.save(dentist2);
            repository.save(dentist3);
            Date currentDate = new Date();
            dentistVisitRepository.save(new DentistVisitEntity(dentist2, currentDate, "08"));
            dentistVisitRepository.save(new DentistVisitEntity(dentist1, currentDate, "08"));
            dentistVisitRepository.save(new DentistVisitEntity(dentist1, currentDate, "11"));
            dentistVisitRepository.save(new DentistVisitEntity(dentist3, currentDate, "08"));
            dentistVisitRepository.save(new DentistVisitEntity(dentist2, currentDate, "09"));
            dentistVisitRepository.save(new DentistVisitEntity(dentist1, currentDate, "14"));
        };
    }
}
