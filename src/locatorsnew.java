import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class locatorsnew {

	public static void main(String[] args) {
		
		//Chrome
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Priyanka Sharma\\eclipse-workspace\\Introduction\\drivers\\chromedriver.exe");
			    WebDriver driver = new ChromeDriver();
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				//firefox
//				System.setProperty("webdriver.gecko.driver","C:\\Users\\Priyanka Sharma\\eclipse-workspace\\Introduction\\drivers\\geckodriver.exe");
//				WebDriver driver = new  FirefoxDriver();
				 
				//Edge
//				System.setProperty("webdriver.edge.driver","C:\\Users\\Priyanka Sharma\\eclipse-workspace\\Introduction\\drivers\\msedgedriver.exe");
//				WebDriver driver = new  EdgeDriver();
				
				driver.get("https://rahulshettyacademy.com/locatorspractice/");
				driver.findElement(By.id("inputUsername")).sendKeys("priyanka@gmail.com");
				driver.findElement(By.name("inputPassword")).sendKeys("priya@123");
				driver.findElement(By.className("submit")).click();
				System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
				driver.findElement(By.linkText("Forgot your password?")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("newpriya");
				driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("priya@gmail.com");
				driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
				driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("priyankas@gmail.com");
				driver.findElement(By.xpath("//form/input[3]")).sendKeys("9911223344");
				driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
				System.out.println(driver.findElement(By.cssSelector("form p")).getText());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
				driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("testnewetc");
				driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
				//driver.findElement(By.id("chkboxOne")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.className("submit")).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.quit();

	}

}
