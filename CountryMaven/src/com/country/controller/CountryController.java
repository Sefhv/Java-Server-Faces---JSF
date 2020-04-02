package com.country.controller;

import java.util.List;

import com.country.model.Country;
import com.country.model.CountryDao;
import com.main.src.LoggerMain;

public class CountryController {

	private CountryDao countryDao = new CountryDao();

	public CountryController() {

	}

	public List<Country> loadCountries() {
		try {
			return countryDao.loadCountries();
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			throw e;
		}
	}

	public void addCountry(Country c) {
		try {
			countryDao.addCountry(c);
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			throw e;
		}
	}

	public void editCountry(Country c) {
		try {
			countryDao.editCountry(c);
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			throw e;
		}
	}

	public void deleteCountry(Country c) {
		try {
			countryDao.deleteCountry(c);
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			throw e;
		}
	}

	public CountryDao getCountryDao() {
		return countryDao;
	}

	public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}
}
