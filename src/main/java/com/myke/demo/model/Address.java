package com.myke.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "mic_address")

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int unit_number; 
    private String street_name;
    private String city; 
    private String state;
    private String country;
    private String latitude; 
    private String longitude; 
    private String name; 
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @JsonBackReference
    private Myke myke;


    public Address() {
   
    }

    public Address(
    long id,
    int unit_number, 
    String street_name,
    String city, 
    String state,
    String country,
    String latitude, 
    String longitude, 
    String name
     ) {
        this.id=id;
        this.unit_number=unit_number;
        this.street_name=street_name;
        this.city=city;
        this.state=state;
        this.country=country;
        this.latitude=latitude;
        this.longitude=longitude;  
    }

   
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "unit_number", nullable = false)
    public int getNumber() {
        return unit_number;
    }
    public void setNumber(int unit_number) {
        this.unit_number = unit_number;
    }
    @Column(name = "street_name", nullable = false)
    public String getStreetName() {
        return street_name;
    }
    public void setStreetName(String street_name) {
        this.street_name = street_name;
    }
    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Column(name = "state", nullable = false)
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    @Column(name = "country", nullable = false)
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @Column(name = "latitude", nullable = false)
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    @Column(name = "longitude", nullable = false)
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } 

   
    
}
