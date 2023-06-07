package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_21_Element_Condition_Status {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitwait;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitwait = new WebDriverWait(driver, 15);
		
		}
	
	//@Test
	public void TC_01_Visible_Displayed_Visibility() {	
		driver.get("https://www.facebook.com/");
		
		//1. Có trên UI (bắt buộc)
		//1. Có trong HTML/DOM (bắt buộc)

		// Wai cho email address textbox hiển thị
		// Chờ cho email Address textbox hiển thị trong 10s
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
	}

	//@Test
	public void TC_02_Invisible_Undisplayed_Unvisibility_PartI() {
		driver.get("https://www.facebook.com/");
		
		//2. Không có trên UI (bắt buộc)
		//1. Có trong HTML
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		// Chờ cho Re-enter email Address textbox không hiển thị trong 10s
				explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		
	}
	
	//@Test
	public void TC_02_Invisible_Undisplayed_Unvisibility_PartII() {
		driver.get("https://www.facebook.com/");
		
		//2. Không có trên UI (bắt buộc)
		//2. Không có trong HTML		
		
		// Chờ cho Re-enter email Address textbox không hiển thị trong 10s
				explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		
	}
	
	//@Test
	public void TC_03_Presence_PartI() {
		driver.get("https://www.facebook.com/");
		
		//1. Có trong HTML (bắt buộc)
		//1. có ở trên UI

		// Chờ cho email address textbox presence trong HTML trong vòng 10s
		explicitwait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		
	}

	//@Test
	public void TC_03_Presence_PartII() {
		driver.get("https://www.facebook.com/");
		
		//1. Có trong HTML (bắt buộc)
		//2. Không có trên UI 		
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		// Chờ cho email address textbox presence trong HTML trong vòng 10s
		explicitwait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
	
	}
	
	@Test
	public void TC_04_Staleness() {
		
		driver.get("https://www.facebook.com/");
		
		//2. Không có ở trên UI (bắt buộc)	
		//2. Không có trong HTML (bắt buộc)
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		sleepInSecond(2);
		
		// Phase 1: Element có trong HTML
		WebElement reEnterEmailAddresstextbox = driver.findElement(By.name("reg_email_confirmation__"));
	
		// Thao tác với element khác làm cho element re-enter Email không còn trong DOM
		
		// Close popup 
		
		driver.findElement(By.cssSelector("img._8idr")).click();
		
		// Chờ cho Re-enter Email textbox không còn trong DOM trong vòng 10s
		
		explicitwait.until(ExpectedConditions.stalenessOf(reEnterEmailAddresstextbox));
		
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
		
	
