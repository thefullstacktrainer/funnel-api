package com.example.funnel.dto;

public class StageRequest {
    private int order;
    private String name;
    private String type;

    // Getters and Setters
    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
