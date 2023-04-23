package webdriver;

import static org.testng.Assert.assertTrue;

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

public class Topic_12_Alert {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Alert alert;
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	
	@Test
	public void TC_01_Accept_Alert() {	
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		sleepInSecond(3);
		
		//Wait và switch qua luôn
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		// Verify Alert title đúng như mong đợi
		Assert.assertEquals(alert.getText(), "I am a JS Alert");		
		
		// Accept alert này
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked an alert successfully");
		
	}

	@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		sleepInSecond(3);
		
		//Wait và switch qua luôn
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		// Verify Alert title đúng như mong đợi
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");		
		
		// Cancel alert này
		alert.dismiss();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");

	}

	@Test
	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		sleepInSecond(3);
		
		//Wait và switch qua luôn
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		// Verify Alert title đúng như mong đợi
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		
		String CourseName = "Automation FC";
		
		// Nhập text vào alert
		alert.sendKeys(CourseName);
		
		// Accept alert này
		alert.accept();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: " + CourseName);
		
	}
	
	@Test
	public void TC_04_Authentication_Alert_C1() {
		driver.get("https://the-internet.herokuapp.com/");
		String authenUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		
		driver.get(passUserAndPassToUrl(authenUrl, "admin", "admin"));
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	}
	
	public String passUserAndPassToUrl(String url, String username, String password) {
		String[] arrayurl = url.split("//");
		return arrayurl[0] + "//" + username + ":" + password + "@" + arrayurl[1];		
		
	
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
		
	
