package com.antoniorodrigo92.TripStatsfrontend.service;

import com.antoniorodrigo92.TripStatsfrontend.dao.LocationRepository;
import com.antoniorodrigo92.TripStatsfrontend.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository theLocationRepository) {
        locationRepository = theLocationRepository;
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public List<Location> findByDate(LocalDateTime date) {
        LocalDateTime begin = date.toLocalDate().atTime(0, 0, 0);
        LocalDateTime end = date.toLocalDate().atTime(23, 59, 59);
        return locationRepository.findByTimestampBetween(begin, end);
    }

    @Override
    public LocalDateTime maxLocationDate() {
        Location maxLocation = locationRepository.findFirstByOrderByTimestampDesc();
        return maxLocation.getTimestamp();
    }

    @Override
    public LocalDateTime minLocationDate() {
        Location minLocation = locationRepository.findFirstByOrderByTimestampAsc();
        return minLocation.getTimestamp();
    }

}
