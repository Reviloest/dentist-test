package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.service.DentistService;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    private final DentistVisitService dentistVisitService;
    private final DentistService dentistService;
    private List<String> times;

    public DentistAppController(DentistVisitService dentistVisitService, DentistService dentistService) {
        this.dentistService = dentistService;
        this.dentistVisitService = dentistVisitService;
        times = new ArrayList<>();
        times.add("08");
        times.add("09");
        for (int i = 0; i < 7; i++) {
            if (i != 2) {
                times.add("1" + i);
            }
        }
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        List<String> dentistNames = dentistService.getNames();
        model.addAttribute("dentistNames", dentistNames);
        for (String s: dentistService.getNames()) {
            System.out.println(s);
        }
        LocalDate date = LocalDate.now();
        model.addAttribute("currentDate", date);
        model.addAttribute("DentistVisitDTO", new DentistVisitDTO());
        model.addAttribute("times", times);
        return "form";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult, Model model) {
            model.addAttribute("dentistList", dentistService.getNames());
            if (bindingResult.hasErrors()) {
                model.addAttribute("errors", true);
                model.addAttribute("times", times);
                return showRegisterForm(model);
            }
            try {
                if (!dentistVisitService.addVisit(dentistVisitDTO.getDentistName(),
                        dentistVisitDTO.getVisitTime(), dentistVisitDTO.getVisitTimeHours())) {
                    model.addAttribute("timeError", true);
                    model.addAttribute("dateMsg", dentistVisitDTO.getVisitTime());
                    model.addAttribute("timeMsg", dentistVisitDTO.getVisitTimeHours());
                    model.addAttribute("timeErrorName", dentistVisitDTO.getDentistName());
                    return showRegisterForm(model);
                }
            } catch (ParseException e) {

            }
            return "redirect:/results";
    }
}
