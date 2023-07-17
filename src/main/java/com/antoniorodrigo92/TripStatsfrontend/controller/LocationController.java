package com.antoniorodrigo92.TripStatsfrontend.controller;

import com.antoniorodrigo92.TripStatsfrontend.entity.Location;
import com.antoniorodrigo92.TripStatsfrontend.service.LocationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/locations")
public class LocationController {
    private LocationService locationService;
    @Value("${google.maps.api_key}")
    private String API_KEY;

    @Autowired
    public LocationController(LocationService theLocationService) {
        locationService = theLocationService;
    }

    @GetMapping("/")
    public String getLocationsByDate(Model model) {

        String today = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
        LocalDateTime maxDate = maxLocationDate();
        String maxDateStr = String.valueOf(maxDate).substring(0, 10);
        LocalDateTime minDate = minLocationDate();
        String minDateStr = String.valueOf(minDate).substring(0, 10);
        List<Location> locations = locationService.findByDate(maxDate);
        String pointPairsJSON = latLongAsJSON(locations);

        model.addAttribute("today", today);
        model.addAttribute("minDate", minDateStr);
        model.addAttribute("maxDate", maxDateStr);

        model.addAttribute("selectedDate", maxDateStr);
        model.addAttribute("locations", locations);
        model.addAttribute("pointPairsJSON", pointPairsJSON);

        model.addAttribute("api_key", API_KEY);

        return "locations";
    }


    @PostMapping("/")
    public String getLocationDate(Model model,
                                  @ModelAttribute("selected_date") Date selected_date) {

        String selected_date_str = new SimpleDateFormat("yyyy-MM-dd").format(selected_date);
        LocalDateTime selected_date_ldt = selected_date.toLocalDate().atTime(0, 0);
        String today = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
        LocalDateTime maxDate = maxLocationDate();
        String maxDateStr = String.valueOf(maxDate).substring(0, 10);
        LocalDateTime minDate = minLocationDate();
        String minDateStr = String.valueOf(minDate).substring(0, 10);
        List<Location> locations = locationService.findByDate(selected_date_ldt);
        String pointPairsJSON = latLongAsJSON(locations);

        model.addAttribute("today", today);
        model.addAttribute("minDate", minDateStr);
        model.addAttribute("maxDate", maxDateStr);

        model.addAttribute("selectedDate", selected_date_str);
        model.addAttribute("locations", locations);
        model.addAttribute("pointPairsJSON", pointPairsJSON);

        model.addAttribute("api_key", API_KEY);

        return "locations";
    }


    @GetMapping("/all")
    public List<Location> findAll() {
        return locationService.findAll();
    }

    private LocalDateTime maxLocationDate() {
        return locationService.maxLocationDate();
    }

    private LocalDateTime minLocationDate() {
        return locationService.minLocationDate();
    }

    private String latLongAsJSON(List<Location> locations) {
        List<Map<String, Double>> pointPairs = new ArrayList<>();
        for (Location location : locations) {
            Map<String, Double> pairs = new HashMap<>();
            pairs.put("lat", location.getLatitude());
            pairs.put("long", location.getLongitude());
            pointPairs.add(pairs);
        }
        String json = new Gson().toJson(pointPairs);
        return json;

    }

}
