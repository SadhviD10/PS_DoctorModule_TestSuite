package com.studio.stepdefinitions;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.commons.lang3.reflect.FieldUtils;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.ScenarioImpl;
import gherkin.formatter.model.Result;

public class BaseSteps extends StepDefinitionInit{

	@Before
	public void setUp() throws Exception {

		System.out.println("STARTING TEST..... ");
		boolean result = checkInternetConnection();
		if (result == false) {
			Thread.sleep(15000);
			checkInternetConnection();
		}
		session = getTestSession();
		Thread.sleep(10000);
	}

	public static boolean checkInternetConnection() throws InterruptedException {
		try {
			final URL url = new URL("http://www.google.com");
			final URLConnection conn = url.openConnection();
			conn.connect();
			System.out.println("Internet is connected...");
			return true;
		} catch (Exception e) {
			System.out.println("Internet is not connected");
			Thread.sleep(10000);
			checkInternetConnection();
			return false;
		}
	}

// @After
	public void tearDown() throws Exception {
		System.out.println("I am in the tear function...");
		try {
			System.out.println("Session reset!!!");
//session.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
//session = null;
			getTestSession();
		}
	}

}
