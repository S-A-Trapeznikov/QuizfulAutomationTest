package by.trapeznikov.testAutomation.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.trapeznikov.testAutomation.driver.DriverSingleton;
import by.trapeznikov.testAutomation.pages.LoginPage;

public class Steps {
	
	private WebDriver driver;
	
	private final Logger logger = LogManager.getRootLogger();
	
	public void initBrowser(){
							
		driver = DriverSingleton.getDriver();
	}
	
	public void clodeDriver(){
		
		driver.quit();
	}
	
	public void loginQuizful(String userName, String password){
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(userName, password);
	}
	
	public boolean isLoggedIn(String userName){
		
		LoginPage loginPage = new LoginPage(driver);
		return loginPage.getLoggedInUserName().trim().toLowerCase().equals(userName);
	}

}
