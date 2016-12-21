package by.trapeznikov.testAutomation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	
	private final String BASE_URL = "http://www.quizful.net/LoginAction.loginForm";
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(name = "loginForm.password")
	WebElement loginFormPassword;
	
	@FindBy(name = "ok")
	WebElement buttonSubmit;
	
	@FindBy(xpath = ".//ul[@id='user-panel']/li[1]/b/a")
	WebElement linkLoggedInUser;
	
	
	public LoginPage(WebDriver driver){
		
		super(driver);
		PageFactory.initElements(this.driver,this);
		
	}

	
	@Override
	public void openPage() {
		
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
		
	}
	
	public void login(String userName, String password){
		login.sendKeys(userName);
		loginFormPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed");
	}
	
	public String getLoggedInUserName(){
				
		return linkLoggedInUser.getText();
		
	}
	

	
}
