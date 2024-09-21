package SeleniumFramework.SeleniumFrameworkFirst.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//Pagefactory
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> ProductNames;
	
	public void getCartPageProducts() {
		driver.findElements(By.cssSelector(".cartSection h3"));
	}
	
	
	public Boolean verifyOrderPageProductsDisplay(String productname) {
		Boolean match = ProductNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	
}

