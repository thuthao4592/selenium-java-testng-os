package webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Popup_Dialog_PartI {
	WebDriver driver;
	WebDriverWait explicitWait;
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
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

//	@Test
	public void TC_01_Fixed_popup_inDOM() {
		driver.get("https://ngoaingu24h.vn/");
		By loginPopup = By.cssSelector("div#modal-login-v1  div.modal-content");
		
		//Verify popup is undisplayd
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
		
		//Click vào button login
		driver.findElement(By.cssSelector("button.login_")).click();
		
		//Verify popup is displayd
		Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
		driver.findElement(By.cssSelector("input#account-input")).sendKeys("automationfc");
		driver.findElement(By.cssSelector("input#password-input")).sendKeys("automationfc");
		driver.findElement(By.cssSelector("button.btn-login-v1")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1 div.error-login-panel")).getText(),"Tài khoản không tồn tại!");
		
	}

//	@Test
	public void TC_02_Fixed_popup_inDOM() {
		driver.get("https://skills.kynaenglish.vn/");
		By loginPopup = By.cssSelector("div#k-popup-account-login");
		
		//Verify popup is undisplayd
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
		driver.findElement(By.cssSelector("a.login-btn")).click();
		sleepInSecond(5);
		Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
		driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation@gmail.com");
		driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#btn-submit-login")).click();
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
		driver.findElement(By.cssSelector("button.k-popup-account-close")).click();
		sleepInSecond(1);
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
		
	}
	
//	@Test
	public void TC_03_Fixed_popup_NotinDOM_tiki() {
		driver.get("https://tiki.vn/");
		sleepInSecond(8);
		By loginPopup = By.cssSelector("div.ReactModal__Content");
		Assert.assertEquals(driver.findElements(loginPopup).size(), 0);
		driver.findElement(By.cssSelector("div[data-view-id*='header_account']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElements(loginPopup).size(), 1);
		Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
		driver.findElement(By.cssSelector("input[name='tel']")).sendKeys("0972342342");
		sleepInSecond(2);
		//Close popup
		driver.findElement(By.cssSelector("img.close-img")).click();
		//Verify không hiển thị
		Assert.assertEquals(driver.findElements(loginPopup).size(), 0);
		driver.findElement(By.cssSelector("div[data-view-id*='header_account']")).click();
		sleepInSecond(2);
		driver.findElement(By.cssSelector("p.login-with-email")).click();
		driver.findElement(By.xpath("//button[text() = 'Đăng nhập']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Email không được để trống']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Mật khẩu không được để trống']")).isDisplayed());
		sleepInSecond(2);
		driver.findElement(By.cssSelector("img.close-img")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElements(loginPopup).size(), 0);
	}
	
	
	@Test
	public void TC_04_Fixed_popup_NotinDOM_Facebook() {
		driver.get("https://www.facebook.com/");
		sleepInSecond(2);
		By CreateAccountPopup = By.xpath("//div[text()='Sign Up']/parent::div/parent::div");
		Assert.assertEquals(driver.findElements(CreateAccountPopup).size(), 0);
				
		driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElements(CreateAccountPopup).size(), 1);
		driver.findElement(By.name("firstname")).sendKeys("thaibinh97");
		driver.findElement(By.name("lastname")).sendKeys("peace");
		driver.findElement(By.name("reg_email__")).sendKeys("thaibinh97@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("123456");
		new Select(driver.findElement(By.id("day"))).selectByVisibleText("10");
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("Dec");
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("1997");
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
		sleepInSecond(2);
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElements(CreateAccountPopup).size(), 0);
		
	}

private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
