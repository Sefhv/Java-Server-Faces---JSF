package com.country.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="country")
public class Country {
	
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private int area;
	
	@Column
	private int population;

	@Column
	private String war;

	public Country() {

	}

	public Country(int id, String name, String description, int area, int population, String war) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.area = area;
		this.population = population;
		this.war = war;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getWar() {
		return war;
	}

	public void setWar(String war) {
		this.war = war;
	}
}
