package com.event.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "eventBean")
@ViewScoped
public class EventBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EventBean() {
		// Default constructor
	}

}
