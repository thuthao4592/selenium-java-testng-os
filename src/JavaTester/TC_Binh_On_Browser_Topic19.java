package JavaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TC_Binh_On_Browser_Topic19 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@Test
	public void TC_01_Run_Chrome() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.quit();
	}
	
	@Test
	public void TC_02_Run_FireFox() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.quit();
	}
	
	@Test
	public void TC_02_Run_Edge() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.quit();
	}

	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}