package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Popup_PartII_Fixed_NOT_IN_DOM {
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

		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);
		
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	
	@Test
	public void TC_01_Fixed_NOT_IN_DOM_Tiki() {
		driver.get("https://tiki.vn/");
		
		// By nó chưa tìm element
		By LoginPopup = By.cssSelector("div.ReactModal__Content");
		
		// Verify nó chưa hiển thị element khi chưa click vào login button (dùng findElements)
		Assert.assertEquals(driver.findElements(LoginPopup).size(), 0);
		
		// Click cho popub hiển thị
		driver.findElement(By.cssSelector("div[data-view-id*='header_account']")).click();
		sleepInSecond(2);
		
		// Verify hiển thị popup
		Assert.assertEquals(driver.findElements(LoginPopup).size(), 1);
		Assert.assertTrue(driver.findElement(LoginPopup).isDisplayed());
				
		driver.findElement(By.cssSelector("p.login-with-email")).click();
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		sleepInSecond(2);
		
		// Verify
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Email không được để trống']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Mật khẩu không được để trống']")).isDisplayed());
		
		driver.findElement(By.cssSelector("button[class='btn-close']")).click();
		sleepInSecond(2);
		
		// Verify thì chỉ dùng được findElements (không dùng được findElement)
		Assert.assertEquals(driver.findElements(LoginPopup).size(), 0);
		
	}

	@Test
	public void TC_02_Fixed_NOT_In_DOM_Facebook() {
		driver.get("https://www.facebook.com/");
		
		By creatAccountPopup = By.xpath("//div[text()='Sign Up']/parent::div/parent::div");
		
		// Verify createAccountPopup không hiển thị
		Assert.assertEquals(driver.findElements(creatAccountPopup).size(), 0);
		
		driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
		sleepInSecond(2);
		
		// Verify createAccountPopup hiển thị
		Assert.assertEquals(driver.findElements(creatAccountPopup).size(), 1);
		
		driver.findElement(By.name("firstname")).sendKeys("Automation");
		driver.findElement(By.name("lastname")).sendKeys("FC");
		driver.findElement(By.name("reg_email__")).sendKeys("0978412578");
		driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");
		
		new Select(driver.findElement(By.id("day"))).selectByVisibleText("18");
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("Aug");
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("1999");
		
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
		
		
		
		
	
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
		
	
