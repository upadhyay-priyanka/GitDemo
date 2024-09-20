import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//invoking chrome dirver
		//chrome->chrome drivers->methods
		//Chrome
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Priyanka Sharma\\eclipse-workspace\\Introduction\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//firefox
//		System.setProperty("webdriver.gecko.driver","C:\\Users\\Priyanka Sharma\\eclipse-workspace\\Introduction\\drivers\\geckodriver.exe");
//		WebDriver driver = new  FirefoxDriver();
//		
		//Edge
//		System.setProperty("webdriver.edge.driver","C:\\Users\\Priyanka Sharma\\eclipse-workspace\\Introduction\\drivers\\msedgedriver.exe");
//		WebDriver driver = new  EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		String title = driver.getTitle();
		System.out.println("Title is"+title);
		System.out.println(driver.getCurrentUrl());
		driver.quit();

	}

}
