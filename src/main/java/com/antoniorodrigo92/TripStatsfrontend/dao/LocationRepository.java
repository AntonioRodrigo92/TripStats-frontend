package com.antoniorodrigo92.TripStatsfrontend.dao;

import com.antoniorodrigo92.TripStatsfrontend.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LocationRepository extends MongoRepository<Location, String> {

    List<Location> findByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);

    Location findFirstByOrderByTimestampAsc();

    Location findFirstByOrderByTimestampDesc();

}
