package com.myke.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mic_cost")

public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cost_id;
    private String cost_amount;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "cost_id")
    // @JsonBackReference
    // private Myke myke;

    public Cost() {

    }

    public Cost(
            long cost_id,
            String cost_amount) {
        this.cost_id = cost_id;
        this.cost_amount = cost_amount;

    }

    @Column(name = "cost_id", nullable = false)
    public long getId() {
        return cost_id;
    }

    public void setId(long cost_id) {
        this.cost_id = cost_id;
    }

    @Column(name = "cost_amount", nullable = false)
    public String getCostAmount() {
        return cost_amount;
    }

    public void setCostAmount(String cost_amount) {
        this.cost_amount = cost_amount;
    }

}