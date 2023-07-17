package com.antoniorodrigo92.TripStatsfrontend.service;

import com.antoniorodrigo92.TripStatsfrontend.dao.TripStatsRepository;
import com.antoniorodrigo92.TripStatsfrontend.entity.TripStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TripStatsServiceImpl implements TripStatsService {
    private TripStatsRepository tripStatsRepository;

    @Autowired
    public TripStatsServiceImpl(TripStatsRepository theTripStatsRepository) {
        tripStatsRepository = theTripStatsRepository;
    }


    @Override
    public List<TripStats> findAll() {
        return tripStatsRepository.findAll();
    }

    @Override
    public TripStats findById(Date date) {
        Optional<TripStats> result = tripStatsRepository.findById(date);
        TripStats tempTripStats = null;
        if(result.isPresent()) {
            tempTripStats = result.get();
        }
        return tempTripStats;
    }

    @Override
    public String maxTripStatsDate() {
        TripStats maxTripStats = tripStatsRepository.findFirstByOrderByTimestampDesc();
        return maxTripStats.getTimestamp();
    }

    @Override
    public String minTripStatsDate() {
        TripStats minTripStats = tripStatsRepository.findFirstByOrderByTimestampAsc();
        return minTripStats.getTimestamp();    }

}
