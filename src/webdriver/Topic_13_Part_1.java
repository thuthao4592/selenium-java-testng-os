package webdriver;
import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Part_1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Actions actions;

	@BeforeClass
	public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actions = new Actions(driver);
	}

	
	public void TC_01_Tooltip() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		sleepInSecond(3);
		
		actions.moveToElement(driver.findElement(By.id("age"))).perform();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
		
	}

	@Test
	public void TC_03_Fahasa() {
		driver.get("https://www.fahasa.com/");
		sleepInSecond(5);
		
		actions.moveToElement(driver.findElement(By.xpath("//span[@class='icon_menu']"))).perform();
		sleepInSecond(3);
		
//		driver.findElement(By.xpath("//span[text()='Sách Trong Nước']")).click();
		
		actions.moveToElement(driver.findElement(By.xpath("//span[text()='Sách Trong Nước']"))).perform();		
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Quản Trị - Lãnh Đạo']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Quản Trị - Lãnh Đạo']")).getText(), "Quản Trị - Lãnh Đạo");
		
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
