package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Action_PartI {
	WebDriver driver;
	Actions action;
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
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	
	//@Test
	public void TC_01_Tooltip() {	
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), 
				"We ask for your age only for statistical purposes.");
		
		// Hoặc chạy câu lệnh trong tab console: setTimeout(() => {debugger;}, 3000);
	}	

	//@Test
	public void TC_02_Myntra() {
		driver.get("https://www.myntra.com/");
		
		// Hover vào Kids
		action.moveToElement(driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Kids']"))).perform();
		driver.findElement(By.xpath("//a[text()='Home & Bath']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(), "Kids Home Bath");
	}

	@Test
	public void TC_03_Fahasa() {
		driver.get("https://www.fahasa.com/");
		sleepInSecond(20);
		
		action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
		sleepInSecond(4);
		
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Sách Trong Nước']"))).perform();
		sleepInSecond(4);
		
		driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Quản Trị - Lãnh Đạo']")).click();		
		
		Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Quản Trị - Lãnh Đạo']")).getText(), "QUẢN TRỊ - LÃNH ĐẠO");
	
		
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
		
	
