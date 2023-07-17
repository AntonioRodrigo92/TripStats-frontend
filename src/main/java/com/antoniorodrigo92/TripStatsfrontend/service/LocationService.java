package com.antoniorodrigo92.TripStatsfrontend.service;

import com.antoniorodrigo92.TripStatsfrontend.entity.Location;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface LocationService {

    List<Location> findAll();

//    List<Location> findByDate(Date date);
    List<Location> findByDate(LocalDateTime date);

    LocalDateTime maxLocationDate();

    LocalDateTime minLocationDate();


}
