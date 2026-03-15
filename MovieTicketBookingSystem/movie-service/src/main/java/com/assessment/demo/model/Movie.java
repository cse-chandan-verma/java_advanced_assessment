package com.assessment.demo.model;

public class Movie {

	private int id;
	private String name;
	private String language;
	private double price;

	public Movie() {
	}

	public Movie(int id, String name, String language, double price) {
		this.id = id;
		this.name = name;
		this.language = language;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}