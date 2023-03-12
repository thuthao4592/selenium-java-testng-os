package JavaTester;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Binh_Demo_Data_Type {
	WebDriver driver;
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register");
	}

	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Binhntt");
	}

	@Test
	public void TC_02_Class() {
		driver.get("https://demo.nopcommerce.com/search");
		driver.findElement(By.className("search-text")).sendKeys("Macbook");
	}

	@Test
	public void TC_03_Name() {
		driver.findElement(By.name("customerCurrency")).click();
	}
	
	@Test
	public void TC_04_TagName() {
		System.out.println(driver.findElements(By.tagName("input")).size());
	}
	
	@Test
	public void TC_05_LinkText() {
		driver.findElement(By.linkText("Addresses")).click();
	}
	
	@Test
	public void TC_06_ParialLinkText() {
		driver.findElement(By.partialLinkText("vendor account")).click();
	}
	
	@Test
	public void TC_07_CSS() {
		driver.get("https://demo.nopcommerce.com/register");
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Binhntt");
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("ThaiBinh");
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("thaib3995@gmail.com");
	}
	
	@Test
	public void TC_08_Xpath() {
		driver.get("https://demo.nopcommerce.com/register");
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Binhntt");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("ThaiBinh");
		//driver.findElement(By.xpath("//input[name='Email']")).sendKeys("thaib3995@gmail.com");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
