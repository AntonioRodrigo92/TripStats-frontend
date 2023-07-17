package com.antoniorodrigo92.TripStatsfrontend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "locations")
public class Location {

    @Id
    public String id;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;
    private LocalDateTime insert_timestamp;
    private String address;

    public Location(double latitude, double longitude, LocalDateTime timestamp, LocalDateTime insert_timestamp, String address) {
//        super();
//        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
        this.insert_timestamp = insert_timestamp;
        this.address = address;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getInsert_timestamp() {
        return insert_timestamp;
    }

    public void setInsert_timestamp(LocalDateTime insert_timestamp) {
        this.insert_timestamp = insert_timestamp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp=" + timestamp +
                ", insert_timestamp=" + insert_timestamp +
                ", address='" + address + '\'' +
                '}';
    }
}
