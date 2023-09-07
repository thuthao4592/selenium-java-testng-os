package webdriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Action_part_2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Actions action;

	@BeforeClass
	public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		action = new Actions(driver);

	}

	@Test
	public void TC_01_ClickandHold() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		List<WebElement> listElement = driver.findElements(By.xpath("//ol[@id= 'selectable']//li"));
		
		action.clickAndHold(listElement.get(0)).moveToElement(listElement.get(3)).release().perform();
		sleepInSecond(3);
		
		List<WebElement> listSelected = driver.findElements(By.xpath("//ol[@id= 'selectable']//li[contains(@class,'ui-selected')]"));
		Assert.assertEquals(listSelected.size(), 4);
		
	}

	@Test
	public void TC_02_Logo() {
		
	}

	@Test
	public void TC_03_Form() {
		
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
