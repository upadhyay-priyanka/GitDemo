package SeleniumFramework.SeleniumFrameworkFirst;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFramework.SeleniumFrameworkFirst.pageobject.CartPage;
import SeleniumFramework.SeleniumFrameworkFirst.pageobject.CheckoutPage;
import SeleniumFramework.SeleniumFrameworkFirst.pageobject.ConfrimationClass;
import SeleniumFramework.SeleniumFrameworkFirst.pageobject.LandingPage;
import SeleniumFramework.SeleniumFrameworkFirst.pageobject.OrderPage;
import SeleniumFramework.SeleniumFrameworkFirst.pageobject.ProductCatalogue;
import SeleniumFrameworkFirst.Testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder extends BaseTest {
	String productname = "ZARA COAT 3";
	
	@Test(dataProvider="getOrder" , groups= {"purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		ProductCatalogue pc = LandingPage.sendValues(input.get("email"), input.get("password"));
		List<WebElement> products = pc.getProductList();
		pc.addProductToCart(productname);
		CartPage cp = pc.goToCartPage();
		Boolean match = cp.verifyProductsDisplay(input.get("productname"));
		Assert.assertTrue(match);
		CheckoutPage cp2 = cp.checkoutEle();
		cp2.selectcountry("India");
		ConfrimationClass confrimPage = cp2.submitOrder();
		String confirmMsg = confrimPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() {
		ProductCatalogue pc = LandingPage.sendValues("priyankasharma262634@gmail.com", "Test@123");
		OrderPage OrderPage = pc.goToOrderPage();
		Assert.assertTrue(OrderPage.verifyOrderPageProductsDisplay(productname));;
	}
	
	@DataProvider
	public Object[][] getOrder() throws IOException {
		
		
		//thired way json file
		
		//second way hashmap
//			HashMap<String, String> map = new HashMap<String, String>();
//			map.put("email", "priyankasharma262634@gmail.com");
//			map.put("password", "Test@123");
//			map.put("productname", "ZARA COAT 3");
//			
//			
//			HashMap<String, String> map1 = new HashMap<String, String>();
//			map1.put("email", "priyankasharma2626341@gmail.com");
//			map1.put("password", "Test@1234");
//			map1.put("productname", "ADIDAS ORIGINAL");
		     List<HashMap<String, String>> data  =  getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//SeleniumFramework//data//PurchaseOrder.json");
			return new Object[][] {
				{data.get(0)},
				{data.get(1)}
				};
				
				//first way dataprovider
			
//			return new Object[][] {
//				{"priyankasharma262634@gmail.com","Test@123","ZARA COAT 3"},
//				{"priyankasharma2626341@gmail.com","Test@1234","ADIDAS ORIGINAL"}
//				};
		
	}
	

}
