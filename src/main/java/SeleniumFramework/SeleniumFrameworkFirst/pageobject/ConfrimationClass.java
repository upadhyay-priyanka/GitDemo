package SeleniumFramework.SeleniumFrameworkFirst.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfrimationClass {

    WebDriver driver;
	
	public ConfrimationClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "hero-primary")
	WebElement confirmationMessage;
	
	public String verifyConfirmationMessage() {
		return confirmationMessage.getText();
	}

}
