package com.example.funnel.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Funnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String filter;
    private LocalDateTime createdAt;
    private String status;

    @OneToMany(mappedBy = "funnel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stage> stages;

    public Funnel() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getFilter() { return filter; }
    public void setFilter(String filter) { this.filter = filter; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Stage> getStages() { return stages; }
    public void setStages(List<Stage> stages) {
        this.stages = stages;
        if (stages != null) {
            for (Stage stage : stages) {
                stage.setFunnel(this);
            }
        }
    }
}
