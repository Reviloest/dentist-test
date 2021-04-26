package com.cgi.dentistapp;

import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.DentistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@SpringBootApplication
public class DentistAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(DentistAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(DentistRepository repository) {
        return args -> {
            repository.save(new Dentist("Kuusk"));
            repository.save(new Dentist("Kullerkupp"));
            repository.save(new Dentist("Kuldsaar"));
        };
    }
}
