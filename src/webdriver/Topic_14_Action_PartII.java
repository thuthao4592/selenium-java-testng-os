package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Action_PartII {
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
	
	
	@Test
	public void TC_01_Click_And_Hold_Block() {	
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		// Tìm một locator đại diện cho cả 12 con số
		List<WebElement> listNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
		
		// 1 - Click vào số 1 (source)	// 2 - Vẫn giữ chuột chưa nhả ra
		action.clickAndHold(listNumber.get(0))		
			
			// 3 - Di chuột tới số (target)
			.moveToElement(listNumber.get(7))
		
			// 4 - Nhả chuột trái ra
			.release()
		
			// Execute
			.perform();
		
		sleepInSecond(2);
				
		List<WebElement> listSelectedNumber = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		Assert.assertEquals(listSelectedNumber.size(), 8);
	}
		

	//@Test
	public void TC_02_Click_And_Holder_Random() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		// Chạy được cho cả MAC /WINDOW
		Keys key = null;
		if (osName.contains("Window")) {
			key = Keys.CONTROL;
		} else {
			key = Keys.COMMAND;
		}
		
		// Tìm một locator đại diện cho cả 12 con số
		List<WebElement> listNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
		
		// Đang chứa 12 số/ item trong list này
		
		// Nhấn Ctrl
		action.keyDown(key).perform();
		
		// Chọn các số random cần click
		
		action.click(listNumber.get(0))
		.click(listNumber.get(3))
		.click(listNumber.get(5))
		.click(listNumber.get(10)).perform();
		
		// Nhả phím control
		action.keyUp(key).perform();
		
		sleepInSecond(2);
		
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
		
	
