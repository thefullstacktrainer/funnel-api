package com.example.funnel.model;

public class Stage {
    public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Stage(int order, String name, String type) {
		super();
		this.order = order;
		this.name = name;
		this.type = type;
	}
	public Stage() {
		// TODO Auto-generated constructor stub
	}
	private int order;
    private String name;
    private String type;
    // constructors, getters/setters
}
