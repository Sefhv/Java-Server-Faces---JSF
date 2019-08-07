package com.country.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="country")
public class Country {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id", unique = true)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="area")
	private int area;
	
	@Column(name="population")
	private int population;

	@Column(name="war")
	private String war;

	public Country() {

	}

	public Country(String name, String description, int area, int population, String war) {
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
