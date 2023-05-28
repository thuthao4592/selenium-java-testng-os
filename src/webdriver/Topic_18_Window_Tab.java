package webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.grid.web.servlet.handler.WebDriverRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Window_Tab {
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
		}
	
	
	//@Test
	public void TC_01_Automationfc_ByID() {	
		driver.get("https://automationfc.github.io/basic-form/index.html");		
		
		// Window/Tab nó sẽ có 2 hàm lấy ra ID của Window/tab đó
		
		// Lấy ra ID của tab hiện tại
		
		String basicformID = driver.getWindowHandle();
		System.out.println("Parent Page = " + basicformID);		

		// Click vào Google link để bật ra 1 tab mới
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(5);
		
		swichToWindowByID (basicformID);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com.vn/");
		
		// Lấy ra ID của tab của Google
		
		String GooglewindowID = driver.getWindowHandle();		
			
		swichToWindowByID (GooglewindowID);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
		
	}

	//@Test
	public void TC_02_Automation_ByTitle() {
		
		// Parent page	
		driver.get("https://automationfc.github.io/basic-form/index.html");		
		String parentID = driver.getWindowHandle();

		// Click vào Google link để bật ra 1 tab mới
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(5);
		
		// Verify trang google 		
		switchToWindowByPageTitle("Google");		
		driver.findElement(By.name("q")).sendKeys("automation");
		
		// Verify trang main
		switchToWindowByPageTitle("Selenium WebDriver");		
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
		
		// Click vào Facebook link để bật ra 1 tab mới
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		sleepInSecond(5);
	
		// Verify trang Facebook 
		
		switchToWindowByPageTitle("Facebook – log in or sign up");	
		driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@gmail.com");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("123");
		sleepInSecond(2);
				
		// Verify trang main
		switchToWindowByPageTitle("Selenium WebDriver");		
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
		
		// Click vào Tiki link để bật ra 1 tab mới
		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
		sleepInSecond(5);
	
		// Verify trang Tiki 
		
		switchToWindowByPageTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");	
		driver.findElement(By.cssSelector("input[class^=FormSearchStyle]")).sendKeys("laptop");		
		sleepInSecond(2);
		
		closeAllWindowExcepParent(parentID);
		sleepInSecond(2);
				
	}

	@Test
	public void TC_03_Live_Guru() {
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		String parentID = driver.getWindowHandle();
		
		// Click vào Iphone - Compare
		
		driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product IPhone has been added to comparison list.");
		
		driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");
		
		driver.findElement(By.cssSelector("button[title='Compare']")).click();
		sleepInSecond(2);
		
		switchToWindowByPageTitle("Products Comparison List - Magento Commerce");
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Compare Products']")).isDisplayed());
		
		//driver.findElement(By.cssSelector("button[title='Close Window']")).click();
		// Dùng hàm close
		closeAllWindowExcepParent(parentID);
		sleepInSecond(2);
		
		// Switch về main page
		switchToWindowByPageTitle("Mobile");
		driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Samsung Galaxy has been added to comparison list.");
	}
	
	public void swichToWindowByID(String otherID) {		
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(otherID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
			}
			
		}
	}
	
	public void closeAllWindowExcepParent(String ParentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(ParentID)) {
				driver.switchTo().window(id);
				driver.close();
				sleepInSecond(2);
			}
			
		}
	}
	
	public void switchToWindowByPageTitle(String expectedPageTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
		
			// Duyệt qua từng ID trước
			driver.switchTo().window(id);		
		
			// Lấy ra title của page này
			String acutalPageTitel = driver.getTitle();			
			
			if (acutalPageTitel.equals(expectedPageTitle)) {
				sleepInSecond(2);
				break;
			}
		}			
				
			}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}	
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
		
	
