package com.antoniorodrigo92.TripStatsfrontend.dao;

import com.antoniorodrigo92.TripStatsfrontend.entity.TripStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface TripStatsRepository extends JpaRepository<TripStats, Date> {

    TripStats findFirstByOrderByTimestampAsc();

    TripStats findFirstByOrderByTimestampDesc();

}
