package com.myke.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "signup_instructions")

public class Signup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long signup_id;
    private String instructions; 
    
    // @OneToOne
    // private Myke myke;


    public Signup() {
   
    }

    public Signup(
    long signup_id,
    String instructions
     ) {
        this.signup_id=signup_id;
        this.instructions=instructions;
         
    }

   

    @Column(name = "signup_id", nullable = false)
    public long getId() {
        return signup_id;
    }
    public void setId(long signup_id) {
        this.signup_id = signup_id;
    }
    @Column(name = "instructions", nullable = false)
    public String getInstructions() {
        return instructions;
    }
    public void setCostAmount(String instructions) {
        this.instructions = instructions;
    }
    
}