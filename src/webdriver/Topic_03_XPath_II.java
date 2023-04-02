package webdriver;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_XPath_II {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		} else {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		}


		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationfc.github.io/basic-form/");
	}

	@Test
	public void TC_01() {
		System.out.println(driver.findElement(By.xpath("//h5[@id='nested']")).getText());
	}

	@Test
	public void TC_02_and_or() {
		
		System.out.println(driver.findElement(By.xpath("//div[@class='container']//h5[contains(text(),'Michael Jackson') and @id='seven']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='container']//h5[contains(text(),'Michael Jackson') and @id='seven' or @id='nine']")).getText());
	}

	@Test
	public void TC_03() {
		System.out.println(driver.findElement(By.xpath("//div[@class='container']//h5[contains(.,'Michael Jackson')]")).getText());
	}
	@Test
	
	public void TC_04_concat() {
		
		System.out.println(driver.findElement(By.xpath("//div[@class='container']//p[concat('Mail Personal or Business Check, Cashier',\"'s Check or money order to:\")]")).getText());
	}
	public void TC_05_insideParent() {
		
		driver.get("https://automationfc.github.io/jquery-selectable/");	
		System.out.println(driver.findElement(By.xpath("//li[2]")).getText());
		}
	//a[contains(text(),'Samsung Galaxy')]/parent::h2/following-sibling::div[@class='actions']/button
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
