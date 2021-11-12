import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;
import org.junit.Test;


public class Teste {
	
	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
	}
}
