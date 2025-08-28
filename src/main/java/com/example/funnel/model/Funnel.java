package com.example.funnel.model;

import java.time.Instant;
import java.util.List;

public class Funnel {
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	public List<Stage> getStages() {
		return stages;
	}
	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}
	public Funnel(String id, String name, String description, String filter, String status, Instant createdAt,
			List<Stage> stages) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.filter = filter;
		this.status = status;
		this.createdAt = createdAt;
		this.stages = stages;
	}
	public Funnel() {
		// TODO Auto-generated constructor stub
	}
	private String id;
    private String name;
    private String description;
    private String filter;
    private String status;  // e.g. CREATED
    private Instant createdAt;
    private List<Stage> stages;
    // constructors, getters/setters
}
