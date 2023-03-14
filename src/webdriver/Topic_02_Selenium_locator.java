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

public class Topic_02_Selenium_locator {
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
		driver.get("https://demo.nopcommerce.com/register");
	}

	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("vykty");
	}

	@Test
	public void TC_02_Class() {

		driver.findElement(By.className("search-box-text")).sendKeys("Samsung");
		driver.findElement(By.className("button-1")).click();
			  
	}
//
	@Test
	public void TC_03_Name() {
		driver.findElement(By.name("advs")).click();
	}
//	
	@Test
	public void TC_04_TagName() {
		driver.findElements(By.tagName("input")).get(1);
		System.out.println(driver.findElements(By.tagName("input")).size());
	}
//	
	@Test
	public void TC_05_LinkText() {
//		Click vào đường link Addresses (Tuyệt đối)
		driver.findElement(By.linkText("Addresses")).click();
	}
//	
	@Test
	public void TC_06_ParialLinkText() {
//		Click vào đường link Addresses (Tương đối)

		driver.findElement(By.partialLinkText("vendor account")).click();
	}
//	
	@Test
	public void TC_07_CSS() {
		driver.get("https://demo.nopcommerce.com/register");
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("vykty");
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("vykty_1");
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("kieuyenvy0512@gmail.com");
	}
	
	@Test
	public void TC_08_Xpath() {
		driver.get("https://demo.nopcommerce.com/register");
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("vykty");
		driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("vykty_2");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("kieuyenvy0512@gmail.com"); 
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
