package SeleniumFramework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFramework.SeleniumFrameworkFirst.pageobject.CartPage;
import SeleniumFramework.SeleniumFrameworkFirst.pageobject.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartLink ;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader ;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToDisAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public OrderPage goToOrderPage() {
		orderHeader.click();
	    OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	
	public CartPage goToCartPage() {
		cartLink.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
}
