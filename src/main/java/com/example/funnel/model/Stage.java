package com.example.funnel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stageOrder;
    private String name;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funnel_id")
    @JsonIgnore   // 👈 prevents infinite recursion in JSON
    private Funnel funnel;

    public Stage() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getStageOrder() { return stageOrder; }
    public void setStageOrder(int stageOrder) { this.stageOrder = stageOrder; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Funnel getFunnel() { return funnel; }
    public void setFunnel(Funnel funnel) { this.funnel = funnel; }
}
