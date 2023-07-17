package com.antoniorodrigo92.TripStatsfrontend.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip_stats")
public class TripStats {

    @Id
    @Column(name = "date")
    private Date date;
    @Column(name = "num_trips")
    private Long numTrips;
    @Column(name = "tripid")
    private String tripId;
    @Column(name = "triptype")
    private String tripType;
    @Column(name = "mileage")
    private Long mileage;
    @Column(name = "startmileage")
    private Long startMileage;
    @Column(name = "overallmileage")
    private Long overallMileage;
    @Column(name = "averagespeed")
    private double averageSpeed;
    @Column(name = "averagefuelconsumption")
    private double averageFuelConsumption;
    @Column(name = "traveltime")
    private Long travelTime;
    @Column(name = "timestamp")
    private String timestamp;
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "date",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<RawTripStats> rawTripStats;


    public TripStats() {
        this.rawTripStats = new ArrayList<RawTripStats>();
    }

    public TripStats(Date date, Long numTrips, String tripId, String tripType, Long mileage, Long startMileage, Long overallMileage, double averageSpeed, double averageFuelConsumption, Long travelTime, String timestamp) {
        this.date = date;
        this.numTrips = numTrips;
        this.tripId = tripId;
        this.tripType = tripType;
        this.mileage = mileage;
        this.startMileage = startMileage;
        this.overallMileage = overallMileage;
        this.averageSpeed = averageSpeed;
        this.averageFuelConsumption = averageFuelConsumption;
        this.travelTime = travelTime;
        this.timestamp = timestamp;
        this.rawTripStats = new ArrayList<RawTripStats>();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getNumTrips() {
        return numTrips;
    }

    public void setNumTrips(Long numTrips) {
        this.numTrips = numTrips;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Long getStartMileage() {
        return startMileage;
    }

    public void setStartMileage(Long startMileage) {
        this.startMileage = startMileage;
    }

    public Long getOverallMileage() {
        return overallMileage;
    }

    public void setOverallMileage(Long overallMileage) {
        this.overallMileage = overallMileage;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public double getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public void setAverageFuelConsumption(double averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public Long getTraveltime() {
        return travelTime;
    }

    public void setTraveltime(Long traveltime) {
        this.travelTime = traveltime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Long travelTime) {
        this.travelTime = travelTime;
    }

    @JsonManagedReference
    public List<RawTripStats> getRawTripStats() {
        return rawTripStats;
    }

    public void setRawTripStats(List<RawTripStats> rawTripStats) {
        this.rawTripStats = rawTripStats;
    }

    @Override
    public String toString() {
        return "TripStats{" +
                "date=" + date +
                ", numTrips=" + numTrips +
                ", tripId='" + tripId + '\'' +
                ", tripType='" + tripType + '\'' +
                ", mileage=" + mileage +
                ", startMileage=" + startMileage +
                ", overallMileage=" + overallMileage +
                ", averageSpeed=" + averageSpeed +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", travelTime=" + travelTime +
                ", timestamp='" + timestamp + '\'' +
                ", rawTripStats=" + rawTripStats +
                '}';
    }

}
