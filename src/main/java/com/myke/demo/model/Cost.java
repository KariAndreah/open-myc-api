package com.myke.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "mic_cost")

public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cost_amount; 
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @JsonBackReference
    private Myke myke;


    public Cost() {
   
    }

    public Cost(
    long id,
    String cost_amount
     ) {
        this.id=id;
        this.cost_amount=cost_amount;
         
    }

   

    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "cost_amount", nullable = false)
    public String getCostAmount() {
        return cost_amount;
    }
    public void setCostAmount(String cost_amount) {
        this.cost_amount = cost_amount;
    }
    
}