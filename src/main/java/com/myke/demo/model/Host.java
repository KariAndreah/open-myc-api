package com.myke.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "mic_host")

public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String first_host; 
    private String second_host; 
    private String third_host; 
    private String fourth_host; 
    private String fifth_host; 

    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @JsonBackReference
    private Myke myke;


    public Host() {
   
    }

    public Host(
    long id,
    String first_host,
    String second_host,
    String third_host,
    String fourth_host,
    String fifth_host
     ) {
        this.id=id;
        this.first_host=first_host;
        this.second_host=second_host;
        this.third_host=third_host; 
        this.fourth_host=fourth_host;
        this.fifth_host=fifth_host; 
         
    }

   

    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "first_host", nullable = false)
    public String getFirstHost() {
        return first_host;
    }
    public void setFirstHost(String first_host) {
        this.first_host = first_host;
    }
     @Column(name = "second_host", nullable = false)
    public String getSecondHost() {
        return second_host;
    }
    public void setSecondHost(String second_host) {
        this.second_host = second_host;
    }
     @Column(name = "third_host", nullable = false)
    public String getThirdHost() {
        return third_host;
    }
    public void setThirdHost(String third_host) {
        this.third_host = third_host;
    }
    @Column(name = "fourth_host", nullable = false)
    public String getFourthHost() {
        return fourth_host;
    }
    public void setFourthHost(String fourth_host) {
        this.fourth_host = fourth_host;
    }
    @Column(name = "fifth_host", nullable = false)
    public String getFifthHost() {
        return fifth_host;
    }
    public void setFifthHost(String fifth_host) {
        this.fifth_host = fifth_host;
    }
    
}