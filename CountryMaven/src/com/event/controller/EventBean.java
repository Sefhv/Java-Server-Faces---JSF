package com.event.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "eventBean")
@SessionScoped
public class EventBean implements Serializable {

	public EventBean() {

	}

}
