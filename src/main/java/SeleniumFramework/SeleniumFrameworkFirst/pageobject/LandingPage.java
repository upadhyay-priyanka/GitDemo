package SeleniumFramework.SeleniumFrameworkFirst.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//Pagefactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(name ="login")
	WebElement login;
	
	@FindBy(css = "[class*= flyInOut]")
	WebElement ErrorMsg;
	
	public ProductCatalogue sendValues(String username, String Password) {
		userEmail.sendKeys(username);
		userPassword.sendKeys(Password);
		login.click();
		return new ProductCatalogue(driver);
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMsg() {
		return ErrorMsg.getText();
	}
	
}
