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
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
//		if (osName.contains("Mac OS")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
//		} else {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//		}


	//	driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Mở trang register
		driver.get("https://demo.nopcommerce.com/register");
	}
	// HTML của FirstName textbox
	// <input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
	// id="FirstName"
	
	// Tên thẻ element (Tagname HTML): input
	// Tên của thuộc tính (Attribute name): type, data-val-required, id, name
	// Giá trị của thuộc tính (Attribute value): text, true, Frish name is required, FirstName

	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Nguyen Thi Lan");
		//input[id='FirstName']
		
	}

	@Test
	public void TC_02_Class() {
		// Mở màn hình 
		driver.get("https://demo.nopcommerce.com/search");
		
		//Nhập text vào search textbox
		driver.findElement(By.className("search-text")).sendKeys("Macbook");
		
	}

	@Test
	public void TC_03_Name() {
		//Click vào Advanced Search checkbox
		driver.findElement(By.name("advs")).click();
		
	}
	@Test
	public void TC_04_TagName() {
		// Tìm ra bao nhiêu thẻ input trên màn hình hiện tại
		System.out.println(driver.findElements(By.tagName("input")).size());
		
	}
	@Test
	public void TC_05_LinkText() {
		//Click vào đường link My account ( tuyệt đối)
		driver.findElement(By.linkText("Addresses")).click();
		
	}
	@Test
	public void TC_06_PartialLinkText() {
		//Click vào đường link Apply for vendor account ( tương đối)
		driver.findElement(By.partialLinkText("vendor account")).click();		
	}
	@Test
	public void TC_07_Css() {
		// Mở lại trang register
		driver.get("https://demo.nopcommerce.com/register");	
		
		//Cách 1
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Selenium");
		
		//Cách 2
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Locator");
		
		//Cách 3
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("test123@gmail.com");
	}
	@Test
	public void TC_08_XPath() {
		// Mở lại trang register
		driver.get("https://demo.nopcommerce.com/register");	
				
		//Cách 1
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Selenium");
				
		//Cách 2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Locator");
				
		//Cách 3
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("lantesst@gmail.com");		
		
	}

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}
}
