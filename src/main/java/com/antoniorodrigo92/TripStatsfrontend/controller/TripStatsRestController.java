package com.antoniorodrigo92.TripStatsfrontend.controller;

import com.antoniorodrigo92.TripStatsfrontend.entity.TripStats;
import com.antoniorodrigo92.TripStatsfrontend.service.TripStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/trip_stats")
public class TripStatsRestController {
    private TripStatsService tripStatsService;

    @Autowired
    public TripStatsRestController(TripStatsService theTripStatsService) {
        tripStatsService = theTripStatsService;
    }


    @GetMapping("/")
    public String getTripsByDate(Model model) {
        String today = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
        String minDate = minTripStatsDate().substring(0, 10);
        String maxDate = maxTripStatsDate().substring(0, 10);
        TripStats tripStats = tripStatsService.findById(Date.valueOf(maxDate));

        model.addAttribute("today", today);
        model.addAttribute("minDate", minDate);
        model.addAttribute("maxDate", maxDate);

        model.addAttribute("selectedDate", maxDate);
        model.addAttribute("tripStats", tripStats);

        return "trip_stats";
    }


    @PostMapping("/")
    public String getTripDate(Model model,
                          @ModelAttribute("selected_date") Date selected_date) {

        String today = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
        String minDate = minTripStatsDate().substring(0, 10);
        String maxDate = maxTripStatsDate().substring(0, 10);

        TripStats tripStats = tripStatsService.findById(selected_date);

        model.addAttribute("today", today);
        model.addAttribute("minDate", minDate);
        model.addAttribute("maxDate", maxDate);

        model.addAttribute("selectedDate", selected_date);
        model.addAttribute("tripStats", tripStats);

        return "trip_stats";
    }






    @GetMapping("/all")
    public List<TripStats> findAll() {
        return tripStatsService.findAll();
    }


    private String maxTripStatsDate() {
        return tripStatsService.maxTripStatsDate();
    }


    private String minTripStatsDate() {
        return tripStatsService.minTripStatsDate();
    }


}
