package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Frame_IFrame {
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
	
	
	@Test
	public void TC_01_Kyna_IFrame() {	
		driver.get("https://skills.kynaenglish.vn/");
		sleepInSecond(4);
		
		// Verify Facebook IFrame hiển thị
		// Facebook iframe vẫn là 1 element của trang Kyna
		
		Assert.assertTrue(driver.findElement(By.xpath("//iframe[contains(@src,'kyna.vn')]")).isDisplayed());
		
		// Cần phải switch vào đúng cái thẻ Iframe chứa các element đó
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'kyna.vn')]")));
	
		String Facebooklike = driver.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div/following-sibling::div")).getText();
		System.out.println(Facebooklike);
		
		Assert.assertEquals(Facebooklike, "165K followers");
		
		// Click vào chat để show lên chat support
		
		// Cần switch về main page
		driver.switchTo().defaultContent();
		
		// Từ main page switch qua iframe chat
		driver.switchTo().frame("cs_chat_iframe");
		
		driver.findElement(By.cssSelector("div.button_bar")).click();
		
		driver.findElement(By.cssSelector("input.input_name")).sendKeys("Dua");
		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0987452154");
		new Select(driver.findElement(By.id("serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
		driver.findElement(By.name("message")).sendKeys("automationfc");
		sleepInSecond(3);

		// Từ chat Iframe quay về trang main page
		
		driver.switchTo().defaultContent();
		
		// Search với từ khóa Excel
		
		driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Excel");
		driver.findElement(By.cssSelector("button.search-button")).click();
		
		List<WebElement> CourseName = driver.findElements(By.cssSelector("div.content>h4"));
		
		for (WebElement course : CourseName) {
			Assert.assertTrue(course.getText().contains("Excel"));
			
		}
		
	}

	@Test
	public void TC_02_HDFC_Bank_Frame() {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		// Swich qua Frame chứa login textbox
		
		driver.switchTo().frame("login_page");
		
		driver.findElement(By.name("fldLoginUserId")).sendKeys("john2022");
		
		driver.findElement(By.cssSelector("a.login-btn")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.cssSelector("input[type='password']")).isDisplayed();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("duacon12");
		
	}

	//@Test
	public void TC_03_() {
		
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
		driver.quit();
	}
}
		
	
