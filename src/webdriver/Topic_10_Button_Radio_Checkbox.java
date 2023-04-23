package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Button_Radio_Checkbox {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	By LoginButton = By.cssSelector("button.fhs-btn-login");
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	
	//@Test
	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
		
		//Verify login Button is disable
		Assert.assertFalse(driver.findElement(LoginButton).isEnabled());
		
		String LoginButtonBackground = driver.findElement(LoginButton).getCssValue("background-image");
		Assert.assertTrue(LoginButtonBackground.contains("rgb(224, 224, 224)"));
		
		
		driver.findElement(By.cssSelector("input#login_username")).sendKeys("0978123123");
		driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
		sleepInSecond(2);
		
		//Verify login Button is enabled
		Assert.assertTrue(driver.findElement(LoginButton).isEnabled());
		
		LoginButtonBackground = driver.findElement(LoginButton).getCssValue("background-color");
		Color LoginButtonBackgroundColor = Color.fromString(LoginButtonBackground);
		Assert.assertEquals(LoginButtonBackgroundColor.asHex().toUpperCase(), "#C92127");			
		
	}

	//@Test
	public void TC_02_Default_Checkbox_Radio_Single() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		// Click 1 checkbox
		driver.findElement(By.cssSelector("input[value='Anemia']")).click();
		
		// Click 1 radio
		driver.findElement(By.cssSelector("input[value='Never']")).click();
		
		// Verify các checkbox & radio đã chọn
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Anemia']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Never']")).isSelected());
		
		//Checkbox có thể tự bỏ chọn (khi click lần 2)
		driver.findElement(By.cssSelector("input[value='Anemia']")).click();
		// Checkbox đã được bỏ chọn
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value='Anemia']")).isSelected());
	
		//Radio không thể tự bỏ chọn được (khi click lần 2)
		driver.findElement(By.cssSelector("input[value='Never']")).click();
		// Radio vẫn được chọn
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Never']")).isSelected());

	}

	//@Test
	public void TC_03_Default_Checkbox_Multiple() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		List<WebElement> allCheckboxs = driver.findElements(By.cssSelector("input.form-checkbox"));
		
		// Dùng vòng lặp để click tất cả các checkbox
		for (WebElement checkbox : allCheckboxs) {
			checkbox.click();			
		}
		
		// Verify tất cả các checkbox
		for (WebElement checkbox : allCheckboxs) {
			Assert.assertTrue(checkbox.isSelected());			
		}		
	}
	
	//@Test
	public void TC_04_Default_Checkbox_DK() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		List<WebElement> allCheckboxs = driver.findElements(By.cssSelector("input.form-checkbox"));
		
		// Nếu như gặp 1 checkbox có tên là X thì mới click
		for (WebElement checkbox : allCheckboxs) {
			if (checkbox.getAttribute("value").equals("Gallstones")) {
			checkbox.click();			
			}	
		}			
		
	}
	

	//@Test
	public void TC_05_Default_Checkbox_() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		sleepInSecond(7);
		// Click checkbox (với những trang defaul là đã tick chọn nên sẽ dùng hàm if để check xem checkbox đã selected chưa)
				
		if (!driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).isSelected()) {
			driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).click();
		}	
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).isSelected());
		
		// Bỏ click checkbox
		if (driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).isSelected()) {
			driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).click();
		}	
		
		Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).isSelected());
		
				
	}
		
	
	@Test
	public void	TC__()	{
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");	
		sleepInSecond(10);		
				
		if (!driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input")).isSelected()) {
			driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input")).click();
		}	
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input")).isSelected());
		
		// Bỏ click checkbox
		if (driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input")).isSelected()) {
			driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input")).click();
		}		
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
		//driver.quit();
	}
}
		
	
