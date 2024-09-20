import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumIntro {

	public static void main(String[] args) {
		
		//Chrome
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Priyanka Sharma\\eclipse-workspace\\Introduction\\drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//firefox
//		System.setProperty("webdriver.gecko.driver","C:\\Users\\Priyanka Sharma\\eclipse-workspace\\Introduction\\drivers\\geckodriver.exe");
//		WebDriver driver = new  FirefoxDriver();
		
		//Edge
//		System.setProperty("webdriver.edge.driver","C:\\Users\\Priyanka Sharma\\eclipse-workspace\\Introduction\\drivers\\msedgedriver.exe");
//		WebDriver driver = new  EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("priyanka@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("priya@123");
		driver.findElement(By.className("submit")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("priyanka");
//		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("priyankasharma262634@gmail.com");
//		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
//		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("priyankasharma262634@gmail.com");
//		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9911223344");
//		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//driver.findElement(By.cssSelector("form p")).getText();
		driver.quit();

	}

}
