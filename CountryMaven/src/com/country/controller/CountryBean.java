package com.country.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.country.model.Country;
import com.hibernate.HibernateUtil;

@Named(value="countryBean")
@SessionScoped
public class CountryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Country country;
	private List<Country> countryList;
	private String statusText = "";	
	
	public CountryBean() {
		testHibernate();
		country = new Country();
		countryList = new ArrayList<>(1);
		countryList.add(new Country(1, "Colombia", "El mejor de todos", 1352, 1324, "No aplica"));
		countryList.add(new Country(8, "Argentina", "El mejor de todos", 1352, 1324, "No aplica"));
		countryList.add(new Country(4, "Brasil", "El mejor de todos", 1352, 1324, "No aplica"));
		countryList.add(new Country(7, "Uruguay", "El mejor de todos", 1352, 1324, "No aplica"));
	}

	public void testHibernate() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {		
			List<Country> countryLists = session.createQuery("from Country",Country.class).list();
			countryLists.forEach(c -> System.out.println(c.getName()));
		} catch (Exception e) {
			if(transaction != null)
                transaction.rollback();
			e.printStackTrace();				
		}
	}
	public String saveCountry() {
		int id_aux=0;
		for(Country c : countryList)
			if(id_aux<c.getId())
				id_aux=c.getId();
		
		country.setId(id_aux+1);
		countryList.add(country);
		statusText = "El pais ha sido guardado correctamente";
		return "index";
	}
	
	public String editCountry() {
		statusText = "El pais ha sido editado correctamente";
		return "index";
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
		country = c;		
		return "read";
	}
	
	public String goDeleteCountry(Country c) {
		countryList.remove(c);
		statusText = "El pais ha sido eliminado correctamente";
		return "index";
	}
	
	public String goIndex() {
		statusText = "";
		return "index";
	}
	
	/**
	 * Getters y Setters
	 * 
	 * */
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
