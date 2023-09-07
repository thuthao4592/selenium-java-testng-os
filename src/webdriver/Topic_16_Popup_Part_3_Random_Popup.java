package webdriver;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Popup_Part_3_Random_Popup {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String email;
	Random random;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		random = new Random();
		email = "automation" + random.nextInt() + "@gmail.com";

	}
	

	public void TC_01_RandomPopup1() {
		driver.get("https://www.javacodegeeks.com/");
		sleepInSecond(12);
		
		By popup = By.className("lepopup-form-inner");
		
		if(driver.findElement(popup).isDisplayed()) {
			driver.findElement(By.xpath("//div[@class='lepopup-input']//input")).sendKeys(email);
//			driver.findElement(By.xpath("//a[@data-label = 'Get the Books' or @data-label = 'OK'] //span")).sendKeys(email);
			driver.findElement(By.xpath("//a//span[text() = 'Get the Books' or text() = 'OK']")).click();
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'lepopup-element-html-content']//h4[text() = 'Thank you!']")), "Thank you!");
		}
		
		driver.findElement(By.id("search-input")).sendKeys("Agile Testing Explained");
		driver.findElement(By.id("search-submit")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'main-content-row']//h1//span[text() = 'Agile Testing Explained']")), "Agile Testing Explained");
	}


	public void TC_02_RandomPopup2() {
		driver.get("https://vnk.edu.vn/");
		sleepInSecond(40);
		
		if (driver.findElement(By.id("tve-p-scroller")).isDisplayed()) {
			driver.findElement(By.cssSelector("div#tve-p-scroller div.thrv_icon")).click();
			sleepInSecond(5);
		}
		
		driver.findElement(By.xpath("//button[text() = 'Danh sách khóa học']")).click();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='title-content']//h1")), "Lịch Khai Giảng tháng 6 – Duy nhất tháng 6 giảm 30-35% học phí ,Tặng 12GB tài liệu full MEPF Thiết kế ,thi công , vẽ shop,Tặng khóa cad cơ điện miễn phí");
	}
	
	@Test
	public void TC_03_RandomPopupNotInDOM() {	
		driver.get("https://dehieu.vn/");
		sleepInSecond(40);

	}
	
	public void sleepInSecond(long miliSecond) {
		try {
			Thread.sleep(miliSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}



}
