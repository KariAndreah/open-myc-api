package com.myke.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "signup_instructions")

public class Signup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String instructions; 
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @JsonBackReference
    private Myke myke;


    public Signup() {
   
    }

    public Signup(
    long id,
    String instructions
     ) {
        this.id=id;
        this.instructions=instructions;
         
    }

   

    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "instructions", nullable = false)
    public String getInstructions() {
        return instructions;
    }
    public void setCostAmount(String instructions) {
        this.instructions = instructions;
    }
    
}