

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

public class SubmitOrder extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {
		String productname = "ZARA COAT 3";
		ProductCatalogue pc = LandingPage.sendValues("priyankasharma262634@gmail.com", "Test@123");
		List<WebElement> products = pc.getProductList();
		pc.addProductToCart(productname);
		CartPage cp = pc.goToCartPage();
		Boolean match = cp.verifyProductsDisplay(productname);
		Assert.assertTrue(match);
		CheckoutPage cp2 = cp.checkoutEle();
		cp2.selectcountry("India");
		ConfrimationClass confrimPage = cp2.submitOrder();
		String confirmMsg = confrimPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
	}

}
