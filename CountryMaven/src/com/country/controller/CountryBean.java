package com.country.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.country.model.Country;
import com.main.src.LoggerMain;

@Named(value = "countryBean")
@ViewScoped
public class CountryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean showList;
	private boolean showCreate;
	private boolean showRead;
	private boolean showEdit;

	private Country country;
	private List<Country> countryList;
	private String statusText;

	private CountryController controller;

	public CountryBean() {
		init();
		hideAll();
		goIndex();
		readCountry();
	}

	private void hideAll() {
		showList = false;
		showCreate = false;
		showRead = false;
		showEdit = false;
	}

	private void init() {
		country = new Country();
		controller = new CountryController();
		countryList = new ArrayList<>(1);
		statusText = "";
	}

	public void readCountry() {
		try {
			countryList = controller.loadCountries();
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
		}
	}

	public void saveCountry() {
		try {
			controller.addCountry(country);
			countryList.add(country);
			hideAll();
			showList = true;
			statusText = "El pais ha sido creado correctamente";
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			throw e;
		}
	}

	public void editCountry() {
		try {
			controller.editCountry(country);
			hideAll();
			showList = true;
			statusText = "El pais ha sido editado correctamente";
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			throw e;
		}
	}

	public void goAddCountry() {
		hideAll();
		showCreate = true;
		country = new Country();
	}

	public void goEditCountry(Country c) {
		hideAll();
		showEdit = true;
		country = c;
	}

	public void goShowCountry(Country c) {
		try {
			hideAll();
			showRead = true;
			country = c;
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			throw e;
		}
	}

	public void goDeleteCountry(Country c) {
		try {
			controller.deleteCountry(c);
			countryList.remove(c);
			statusText = "El pais ha sido eliminado correctamente";
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			throw e;
		}
	}

	public void goIndex() {
		hideAll();
		showList = true;
		statusText = "";
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

	public CountryController getController() {
		return controller;
	}

	public void setController(CountryController controller) {
		this.controller = controller;
	}
}
