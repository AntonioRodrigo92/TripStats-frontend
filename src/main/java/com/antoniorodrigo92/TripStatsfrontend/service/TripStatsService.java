package com.antoniorodrigo92.TripStatsfrontend.service;

import com.antoniorodrigo92.TripStatsfrontend.entity.TripStats;

import java.sql.Date;
import java.util.List;

public interface TripStatsService {

    List<TripStats> findAll();

    TripStats findById(Date date);

    String maxTripStatsDate();

    String minTripStatsDate();

}
