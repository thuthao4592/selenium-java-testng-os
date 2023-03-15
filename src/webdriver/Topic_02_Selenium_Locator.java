package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

		
	@BeforeClass
	public void beforeClass() {

			if (osName.contains("Windows")) {
				System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/register");
			
	}

	
	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
	}

	@Test
	public void TC_02_Class() {
		driver.get("https://demo.nopcommerce.com/search");		
		driver.findElement(By.className("search-text")).sendKeys("Macbook");		
	}

	@Test
	public void TC_03_Name() {
		driver.findElement(By.name("advs")).click();
		
	}

	@Test
	public void TC_04_Tagname() {
		driver.findElements(By.tagName("input")).size();
		
	}

	@Test
	public void TC_05_Linktext() {
		driver.findElement(By.linkText("Addresses")).click();
		
	}

	@Test
	public void TC_06_PartialLinkText() {
		driver.findElement(By.partialLinkText("vendor account")).click();
		
	}	
	
	@Test
	public void TC_07_Css() {
	//chay trang register
	driver.get("https://demo.nopcommerce.com/register");
	//1
	driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Selenium");
	//2
	driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Locator");
	//3
	driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("automation@gmail.com");
	}
		
	@Test
	public void TC_08_XPath() {
		//chay trang register
		driver.get("https://demo.nopcommerce.com/register");
		//1
		driver.findElement(By.xpath("//input[@data-val-required='First name is required.']")).sendKeys("Selenium");
		//2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Locator");
		//3
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("automation@gmail.com");
	}	
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}