package com.country.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.country.model.Country;
import com.country.model.CountryDao;

@Named(value = "countryBean")
@SessionScoped
public class CountryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Country country;
	private List<Country> countryList;
	private String statusText = "";

	public CountryBean() {
		country = new Country();
		countryList = new ArrayList<>(1);
		readCountry();
//		countryList.add(new Country(1, "Colombia", "El mejor de todos", 1352, 1324, "No aplica"));
//		countryList.add(new Country(8, "Argentina", "El mejor de todos", 1352, 1324, "No aplica"));
//		countryList.add(new Country(4, "Brasil", "El mejor de todos", 1352, 1324, "No aplica"));
//		countryList.add(new Country(7, "Uruguay", "El mejor de todos", 1352, 1324, "No aplica"));
	}

	public void readCountry() {
		try {
			countryList = CountryDao.loadCountries();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String saveCountry() {
		try {
			int id_aux = 0;
			for (Country c : countryList)
				if (id_aux < c.getId())
					id_aux = c.getId();

			country.setId(id_aux + 1);
			CountryDao.addCountry(country);
			countryList.add(country);
			statusText = "El pais ha sido guardado correctamente";
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String editCountry() {
		try {
			CountryDao.editCountry(country);
			statusText = "El pais ha sido editado correctamente";
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String goAddCountry() {
		country = new Country();
		return "create";
	}

	public String goEditCountry(Country c) {
		country = c;
		return "edit";
	}

	public String goShowCountry(Country c) {
		try {
			country = c;
			return "read";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}		
	}

	public String goDeleteCountry(Country c) {
		try {
			CountryDao.deleteCountry(c);
			countryList.remove(c);
			statusText = "El pais ha sido eliminado correctamente";
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String goIndex() {
		statusText = "";
		return "index";
	}

	/**
	 * Getters y Setters
	 * 
	 */
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
}
