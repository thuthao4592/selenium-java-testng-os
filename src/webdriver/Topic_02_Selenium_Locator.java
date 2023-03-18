package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class Topic_02_Selenium_Locator {
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
		
		//Mở trang Register
		driver.get("https://demo.nopcommerce.com/register");
	}
	@Test
	public void TC_01_ID(){
		driver.findElement(By.id("FirstName")).sendKeys("Automation");;
	}
	
	@Test
	public void TC_02_Class(){
		driver.get("https://demo.nopcommerce.com/search");
		
		driver.findElement(By.className("search-text")).sendKeys("Macbook");
	}
	
	@Test
	public void TC_03_Name(){
		//click vao checkbox
		driver.findElement(By.name("advs")).click();;
	}
	
	@Test
	public void TC_04_TagName(){
		//tim bao nhieu the input tren man hinh hien tại
		System.out.println(driver.findElement(By.tagName("input")).getSize());
	}
	
	@Test
	public void TC_05_LinkText(){
		//click vào đường link Addresses
		driver.findElement(By.linkText("Addresses")).click();
		}
	
	@Test
	public void TC_06_PartialLinkText(){
		//click vào đường Apply for vendor Account
		driver.findElement(By.partialLinkText("vendor account")).click();
		
	}
	
	@Test
	public void TC_07_Css(){
		//Mở lại trang Register
		driver.get("https://demo.nopcommerce.com/register");
		
		//1
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Selenium");
		
		//2
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Locator");
		
		//3
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("phuong@gmail.com");
	}
	
	@Test
	public void TC_08_Xpath(){
		//Mở lại trang Register
		driver.get("https://demo.nopcommerce.com/register");
		
		//1
		driver.findElement(By.xpath("//input[@data-val-required=\'First name is required.\']")).sendKeys("Selenium");
		
		//2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Locator");
		
		//3
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("phuong@gmail.com");
	
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
