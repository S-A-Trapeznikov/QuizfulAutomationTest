package by.trapeznikov.testAutomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.trapeznikov.testAutomation.steps.Steps;

public class QizfulAutomationTest {
	
	private Steps steps;
	private final String LOGIN = "Trapeznikov";
	private final String PASSWORD = "Trapeznikov";
	
	@BeforeMethod(description = "Init broswer")
	public void setUp(){
		steps = new Steps();
		steps.initBrowser();
	}
	
	@Test(description = "Login to Quizful")
	public void oneCanLoginQuizful(){
		steps.loginQuizful(LOGIN, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(LOGIN.trim().toLowerCase()));
	}
	
	
	@AfterMethod(description = "Stop Browser")
	public void stopBrowser(){
		steps.clodeDriver();
	}

}
