package com.antoniorodrigo92.TripStatsfrontend.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "raw_trip_stats")
public class RawTripStats {

    @Column(name = "triptype")
    private String tripType;
    @Id
    @Column(name = "tripid")
    private Long tripID;
    @Column(name = "averagefuelconsumption")
    private Long averageFuelConsumption;
    @Column(name = "averagespeed")
    private Long averageSpeed;
    @Column(name = "mileage")
    private Long mileage;
    @Column(name = "startmileage")
    private Long startMileage;
    @Column(name = "traveltime")
    private Long traveltime;
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Column(name = "reportreason")
    private String reportReason;
    @Column(name = "overallmileage")
    private Long overallMileage;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "date")
    private TripStats date;


    public RawTripStats() {

    }

    public RawTripStats(String tripType, Long tripID, Long averageFuelConsumption, Long averageSpeed, Long mileage, Long startMileage, Long traveltime, Timestamp timestamp, String reportReason, Long overallMileage) {
        this.tripType = tripType;
        this.tripID = tripID;
        this.averageFuelConsumption = averageFuelConsumption;
        this.averageSpeed = averageSpeed;
        this.mileage = mileage;
        this.startMileage = startMileage;
        this.traveltime = traveltime;
        this.timestamp = timestamp;
        this.reportReason = reportReason;
        this.overallMileage = overallMileage;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public Long getTripID() {
        return tripID;
    }

    public void setTripID(Long tripID) {
        this.tripID = tripID;
    }

    public Long getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public void setAverageFuelConsumption(Long averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public Long getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Long averageSpeed) {
        this.averageSpeed = averageSpeed;
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

    public Long getTraveltime() {
        return traveltime;
    }

    public void setTraveltime(Long traveltime) {
        this.traveltime = traveltime;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public Long getOverallMileage() {
        return overallMileage;
    }

    public void setOverallMileage(Long overallMileage) {
        this.overallMileage = overallMileage;
    }

    @JsonBackReference
    public TripStats getDate() {
        return date;
    }

    public void setDate(TripStats date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RawTripStats{" +
                "tripType='" + tripType + '\'' +
                ", tripID=" + tripID +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", averageSpeed=" + averageSpeed +
                ", mileage=" + mileage +
                ", startMileage=" + startMileage +
                ", traveltime=" + traveltime +
                ", timestamp=" + timestamp +
                ", reportReason='" + reportReason + '\'' +
                ", overallMileage=" + overallMileage +
                ", date=" + date +
                '}';
    }
}
