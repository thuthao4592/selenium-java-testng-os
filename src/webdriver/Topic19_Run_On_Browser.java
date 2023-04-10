package webdriver;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic19_Run_On_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
		@Test
		public void TC_Run_Chrome() {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			driver.quit();
		}
		@Test
		public void TC_Run_Firefox() {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver(); 
			driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			driver.quit();
		}
}
