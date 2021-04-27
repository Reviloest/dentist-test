package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.service.DentistService;
import com.cgi.dentistapp.service.DentistVisitService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/booking")
    public String showBookings(Model model) {
        List<DentistVisitEntity> visits = new ArrayList<>(dentistVisitService.findAll());
        model.addAttribute("visits", visits);
        return "booked";
    }

    @GetMapping("/booking/delete/{id}")
    public String deleteBooking(@PathVariable(value = "id") Long id, Model model) {
        dentistVisitService.delete(id);
        List<DentistVisitEntity> visits = new ArrayList<>(dentistVisitService.findAll());
        model.addAttribute("visits", visits);
        return "booked";
    }

    @GetMapping("booking/change/redirect/{id}")
    public String changeBookingRedirect(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("id", id);
        DentistVisitEntity dentistVisitEntity = dentistVisitService.findVisitById(id);
        String dentistName = dentistVisitEntity.getDentistName();
        model.addAttribute("dentistName", dentistName);
        String startDate = dentistVisitEntity.getDate();
        model.addAttribute("startDate", startDate);
        String startHour = dentistVisitEntity.getStartHour();
        model.addAttribute("startHour", startHour);
        String endHour = dentistVisitEntity.getEndHour();
        model.addAttribute("endHour", endHour);
        return "change";
    }

    @GetMapping("booking/change/{id}")
    public String changeBooking(
            @RequestParam(value = "dentistName", required = false) String dentistName,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "startTime", required = false) String startTime,
            @PathVariable(value = "id") Long id, Model model) {

        return null;
    }

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        List<String> dentistNames = dentistService.getNames();
        model.addAttribute("dentistNames", dentistNames);
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
                System.out.println("target: " + bindingResult.getModel());
                model.addAttribute("errors", true);
                model.addAttribute("times", times);
                return showRegisterForm(model);
            }
            try {
                if (!dentistVisitService.addVisit(dentistVisitDTO.getDentistName(),
                        dentistVisitDTO.getVisitTime(), dentistVisitDTO.getVisitTimeHours())) {
                    model.addAttribute("timeError", true);
                    String errorStr = "Viga aja sisestamisel, arstil ";
                    String dentistName = dentistVisitDTO.getDentistName();
                    String visitTime = dentistVisitDTO.getVisitTime();
                    String[] visitTimeConverted = visitTime.split("-");
                    String visitTimeNew = visitTimeConverted[2] + "-" + visitTimeConverted[1] + "-" + visitTimeConverted[0];
                    String visitTimeHours = dentistVisitDTO.getVisitTimeHours();
                    errorStr += dentistName + " on juba registreering kuupäeval "
                            + visitTimeNew + " ja kellaajal " + visitTimeHours
                    + ":00";
                    model.addAttribute("errorStr", errorStr);
                    //model.addAttribute("dateMsg", dentistVisitDTO.getV
                    // isitTime());
                    //model.addAttribute("timeMsg", dentistVisitDTO.getVisitTimeHours());
                    //model.addAttribute("timeErrorName", dentistVisitDTO.getDentistName());
                    return showRegisterForm(model);
                }
            } catch (ParseException e) {

            }
            return "redirect:/results";
    }
}
