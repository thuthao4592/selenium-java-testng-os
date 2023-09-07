package webdriver;
import java.util.List;
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

public class Topic_15_Action_part_3 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Actions action;
	JavascriptExecutor Jsexcutor;

	@BeforeClass
	public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		action = new Actions(driver);
		Jsexcutor = (JavascriptExecutor) driver;

	}

	public void TC_01_DoubleClick() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(3);
		
		//scroll đến vị trí cần
		Jsexcutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Double click me']")));
		
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		sleepInSecond(2);
		
		Assert.assertEquals(driver.findElement(By.id("demo")).getText(), "Hello Automation Guys!");
		
	}

	public void TC_02_RightClick() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		sleepInSecond(3);
		
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		sleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]")).isDisplayed());
		
		action.moveToElement(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]"))).perform();
		sleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());	
	}
	
	@Test
	public void TC_03_Form() {
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		sleepInSecond(3);
		
		WebElement smallCircel = driver.findElement(By.id("draggable"));
		WebElement bigCircle = driver.findElement(By.id("droptarget"));
				
		action.dragAndDrop(smallCircel, bigCircle).perform();
		sleepInSecond(2);
		
		Assert.assertEquals(bigCircle.getText(), "You did great!");
		
		String cssColor = bigCircle.getCssValue("background-color");
		
		System.out.println(Color.fromString(cssColor).asHex().toUpperCase());
		
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
