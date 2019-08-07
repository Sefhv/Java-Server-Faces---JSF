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

	private boolean showList;
	private boolean showCreate;
	private boolean showRead;
	private boolean showEdit;

	public CountryBean() {
		init();
		readCountry();
	}

	public void init() {
		country = new Country();
		countryList = new ArrayList<>(1);
		showList = true;
		showCreate = false;
		showRead = false;
		showEdit = false;
	}

	public void readCountry() {
		try {
			countryList = CountryDao.loadCountries();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveCountry() {
		try {
			CountryDao.addCountry(country);
			countryList.add(country);
			showList = true;
			showCreate = false;
			showRead = false;
			showEdit = false;
			statusText = "El pais ha sido creado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void editCountry() {
		try {
			CountryDao.editCountry(country);
			showList = true;
			showCreate = false;
			showRead = false;
			showEdit = false;
			statusText = "El pais ha sido editado correctamente";			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	public void goAddCountry() {
		showList = false;
		showCreate = true;
		showRead = false;
		showEdit = false;
		country = new Country();
	}

	public void goEditCountry(Country c) {
		showList = false;
		showCreate = false;
		showRead = false;
		showEdit = true;
		country = c;
	}

	public void goShowCountry(Country c) {
		try {
			showList = false;
			showCreate = false;
			showRead = true;
			showEdit = false;
			country = c;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void goDeleteCountry(Country c) {
		try {
			CountryDao.deleteCountry(c);
			countryList.remove(c);
			statusText = "El pais ha sido eliminado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void goIndex() {
		statusText = "";
		showList = true;
		showCreate = false;
		showRead = false;
		showEdit = false;
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

	public boolean isShowList() {
		return showList;
	}

	public void setShowList(boolean showList) {
		this.showList = showList;
	}

	public boolean isShowCreate() {
		return showCreate;
	}

	public void setShowCreate(boolean showCreate) {
		this.showCreate = showCreate;
	}

	public boolean isShowEdit() {
		return showEdit;
	}

	public void setShowEdit(boolean showEdit) {
		this.showEdit = showEdit;
	}

	public boolean isShowRead() {
		return showRead;
	}

	public void setShowRead(boolean showRead) {
		this.showRead = showRead;
	}
}