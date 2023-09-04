package com.myke.demo.model;


import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "mics")
public class Myke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    // private int address_id;
    private String borough; 
    private LocalTime start_time; 
    private String day;
    // private int host;
    // private int cost; 
    // private int signup; 
    private LocalDate confirmed; 

   

    public Myke() {
        super();
    }

    public Myke(
    long id, 
    String name, 
    int address_id, 
    LocalTime start_time, 
    String day,
    String borough,
    // int host,
    // int cost,
    int signup,
    LocalDate date ) {
        this.id=id;
        this.name=name;
        // this.address_id=address_id;
        this.borough=borough; 
        this.start_time=start_time;
        // this.host=host;
        // this.cost=cost;
        // this.signup=signup;
        this.confirmed=date;  
    }

  

    

    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // @Column(name = "address_id", nullable = false)
    // public int getAddress() {
    //     return address_id;
    // }
    // public void setAddress(int address_id) {
    //     this.address_id = address_id;
    // }

    @Column(name = "start_time", nullable = false)
    public LocalTime getTime() {
        return start_time;
    }
    public void setTime(LocalTime start_time) {
        this.start_time = start_time;
    }
    @Column(name = "day", nullable = false)
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    @Column(name = "borough", nullable = false)
    public String getBorough() {
        return borough;
    }
    public void setBorough(String borough) {
        this.borough = borough;
    }
    // @Column(name = "host", nullable = false)
    // public int getHostId() {
    //     return host;
    // }
    // public void setHostId(int host) {
    //     this.host = host;
    // }
    // @Column(name = "cost", nullable = false)
    // public int getCostId() {
    //     return cost;
    // }
    // public void setCostId(int cost) {
    //     this.cost = cost;
    // }
    // @Column(name = "signup_id", nullable = false)
    // public int getSignupId() {
    //     return signup;
    // }
    // public void setSignupId(int signup) {
    //     this.signup = signup;
    // }
    @Column(name = "confirmed", nullable = false)
    public LocalDate getConfirmedDate() {
        return confirmed;
    }
    public void setConfirmedDate(LocalDate confirmed) {
        this.confirmed = confirmed;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "myke")
    @JsonManagedReference
    private Address address; 

    public Address getAddress(){
        return address; 
    }

    public void setAddress(Address address) {
        this.address = address; 
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "myke")
    @JsonManagedReference
    private Cost cost; 

    public Cost getCost(){
        return cost; 
    }

    public void setCost(Cost cost) {
        this.cost = cost; 
    }

  


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "myke")
    @JsonManagedReference
    private Signup signup; 

    public Signup getSignup(){
        return signup; 
    }

    public void setSignup(Signup signup) {
        this.signup = signup; 
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "myke")
    @JsonManagedReference
    private Host host; 

    public Host getHost(){
        return host; 
    }

    public void setHost(Host host) {
        this.host = host; 
    }

   

}
