package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Alert {
	WebDriver driver;
	Alert alert;
	WebDriverWait expliciWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		expliciWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
//		Wait và Switch qua luôn
		alert = expliciWait.until(ExpectedConditions.alertIsPresent());
		
//		Verify Alert title đúng như mong đợi
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		
//		Accept cái alert này
		alert.accept();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked an alert successfully");
	}
	
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
//		Wait và Switch qua luôn
		alert = expliciWait.until(ExpectedConditions.alertIsPresent());
		
//		Verify Alert title đúng như mong đợi
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		
//		Accept cái alert này
		alert.dismiss();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
	}
	
	@Test
	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
//		Wait và Switch qua luôn
		alert = expliciWait.until(ExpectedConditions.alertIsPresent());
		
//		Verify Alert title đúng như mong đợi
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		
//		Accept cái alert này
		alert.dismiss();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
	}
	

	public void TC_04_Prompt_Alert() {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();
		
//		Wait và Switch qua luôn
		alert = expliciWait.until(ExpectedConditions.alertIsPresent());
		
//		Verify Alert title đúng như mong đợi
		Assert.assertEquals(alert.getText(), "Customer ID cannot be left blank");
		
//		Accept cái alert này
		alert.dismiss();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
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
