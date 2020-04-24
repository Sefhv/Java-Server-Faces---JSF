package CityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.model.City;
import co.edu.model.Country;

@Named
@ViewScoped
public class CountryCityBean implements Serializable {

	private Long idCountry;
	private Long idCity;

	private List<Country> countryList;
	private List<City> cityList;
	private List<City> cityTmpList;

	public CountryCityBean() {
		countryList = new ArrayList<>(1);
		countryList.add(new Country(1L, "Colombia"));
		countryList.add(new Country(2L, "Chile"));
		countryList.add(new Country(3L, "Ecuador"));
		countryList.add(new Country(4L, "Peru"));

		cityList = new ArrayList<>(1);
		cityList.add(new City(1L, "Bogotá", 1L));
		cityList.add(new City(2L, "Cali", 1L));
		cityList.add(new City(3L, "Medellin", 1L));

		cityList.add(new City(4L, "Santiago", 2L));
		cityList.add(new City(5L, "Concepción", 2L));
		cityList.add(new City(6L, "Valparaiso", 2L));

		cityList.add(new City(7L, "Quito", 3L));
		cityList.add(new City(8L, "Cuenca", 3L));
		cityList.add(new City(9L, "Guayaquil", 3L));

		cityList.add(new City(10L, "Lima", 4L));
		cityList.add(new City(11L, "Arequipa", 4L));
		cityList.add(new City(12L, "Ayacucho", 4L));

	}

	public void handleCountryChange() {
		if (idCountry != null && idCountry.equals(0L))
			;
		{
			cityTmpList = new ArrayList<>(1);
			for (City c : cityList) {
				if (c.getIdCountry().equals(idCountry)) {
					cityTmpList.add(c);
				}
			}
		}
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<City> getCityTmpList() {
		return cityTmpList;
	}

	public void setCityTmpList(List<City> cityTmpList) {
		this.cityTmpList = cityTmpList;
	}

	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}

	public Long getIdCity() {
		return idCity;
	}

	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}

}
