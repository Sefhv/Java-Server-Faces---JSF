package com.country.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.connection.HibernateUtil;
import com.main.src.LoggerMain;

public class CountryDao extends HibernateUtil {

	private Session session;
	private Transaction transaction = null;

	public CountryDao() {
		//
	}
	
	public List<Country> loadCountries() {
		List<Country> countryList = new ArrayList<>(1);
		try {
			session = getSessionFactory().openSession();
			transaction = getSession().beginTransaction();
			countryList = getSession().createQuery("from Country", Country.class).list();
			return countryList;
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			transaction.rollback();
			throw e;
		} finally {
			getSession().close();
		}
	}

	public void addCountry(Country c) {
		List<Integer> countryList;
		try {
			session = getSessionFactory().openSession();
			transaction = getSession().beginTransaction();
			countryList = getSession().createQuery("select id from Country", Integer.class).list();
			int id = countryList.get(0);
			for (Integer ct : countryList) {
				if (id < ct)
					id = ct;
			}
			c.setId(id + 1);
			getSession().save(c);
			transaction.commit();
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public void editCountry(Country c) {
		try {
			session = getSessionFactory().openSession();
			transaction = getSession().beginTransaction();
			session.update(c);
			transaction.commit();
		} catch (Exception e) {
			LoggerMain.getLogger().error(e);
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public void deleteCountry(Country c) {
		try {
			session = getSessionFactory().openSession();
			transaction = getSession().beginTransaction();
			session.delete(c);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}