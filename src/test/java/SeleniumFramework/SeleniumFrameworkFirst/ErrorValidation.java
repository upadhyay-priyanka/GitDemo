package SeleniumFramework.SeleniumFrameworkFirst;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFramework.SeleniumFrameworkFirst.pageobject.CartPage;
import SeleniumFramework.SeleniumFrameworkFirst.pageobject.CheckoutPage;
import SeleniumFramework.SeleniumFrameworkFirst.pageobject.ConfrimationClass;
import SeleniumFramework.SeleniumFrameworkFirst.pageobject.LandingPage;
import SeleniumFramework.SeleniumFrameworkFirst.pageobject.ProductCatalogue;
import SeleniumFrameworkFirst.Testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void submitOrder() throws IOException, InterruptedException {
		String productname = "ZARA COAT 3";
		ProductCatalogue pc = LandingPage.sendValues("priyankasharm262632334@gmail.com", "Test6565@123");
		Assert.assertEquals("Incorrect email password.", LandingPage.getErrorMsg());
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		String productname = "ZARA COAT 3";
		ProductCatalogue pc = LandingPage.sendValues("priyankasharma262634@gmail.com", "Test@123");
		List<WebElement> products = pc.getProductList();
		pc.addProductToCart(productname);
		CartPage cp = pc.goToCartPage();
		Boolean match = cp.verifyProductsDisplay("ZARA COAT 3454");
		Assert.assertFalse(match);
	}

}
