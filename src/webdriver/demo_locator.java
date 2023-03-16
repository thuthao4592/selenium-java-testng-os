package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class demo_locator {
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
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register");
	}
	@Test
	public void TC_01_Id() {
		driver.findElement(By.id("FirstName")).sendKeys("AutoTesThuy");
	}
	
	@Test
	public void TC_02_Class() {
		driver.get("https://demo.nopcommerce.com/search");
		driver.findElement(By.className("search-text")).sendKeys("Apple");

	}
	@Test
	public void TC_03_Name() {
		driver.findElement(By.name("advs")).click();
	}
	@Test
	public void TC_04_TagName() {
		driver.findElements(By.tagName("button")).size();
	}
	@Test
	public void TC_05_LinkText() {
		driver.findElement(By.linkText("Recently viewed products")).click();
	}
	@Test
	public void TC_06_PartialLinkText() {
		driver.findElement(By.partialLinkText("viewed products")).click();
	}
	@Test
	public void TC_07_Css() {
		driver.get("https://demo.nopcommerce.com/register");

		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nguyen");
		//driver.findElement(By.cssSelector("input[id=LastName]")).sendKeys("Nguyen");
		//driver.findElement(By.cssSelector("input[name=LastName]")).sendKeys("Nguyen");

	}
	@Test
	public void TC_08_Xpath() {
		driver.get("https://demo.nopcommerce.com/register");

		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Nguyen");
		}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
