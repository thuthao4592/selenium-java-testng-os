package Java_Exception;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleException {
	
	FirefoxDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();	
	}

		
	//@Test
	public void TC_01() {
		driver.get("http://live.techpanda.org/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("//div[@id='header-account']//a[text()='My Account']")).click();
		
	}
	
	@Test
	public void TC_02() {
		driver.get("https://automationfc.github.io/basic-form/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		driver.switchTo().frame(0);	
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}

