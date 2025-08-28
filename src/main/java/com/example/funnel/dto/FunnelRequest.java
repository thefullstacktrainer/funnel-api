package com.example.funnel.dto;

import java.util.List;

public class FunnelRequest {
    private String name;
    private String description;
    private String filter;
    private List<StageRequest> stages;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getFilter() { return filter; }
    public void setFilter(String filter) { this.filter = filter; }

    public List<StageRequest> getStages() { return stages; }
    public void setStages(List<StageRequest> stages) { this.stages = stages; }
}
