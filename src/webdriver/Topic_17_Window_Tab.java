package webdriver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Window_Tab {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	public void TC_01_ID() {
		
		//Parent Page
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Window/Tab nó sẽ có 2 hàm để lấy ra ID cảu Window/Tab
		
		// 1 - Nó sẽ lấy ra ID của Tab/Window mà nó đang đứng (active)
		String SeleniumPageWindow  = driver.getWindowHandle();
		System.out.println("Parent Page" + SeleniumPageWindow);
		
		// Click vào google để bật ra 1 tab mới
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(4);
		
		// Lấy hết tất cả các ID ra
		Set<String> allWindowIDs = driver.getWindowHandles();
		System.out.println(allWindowIDs);
		// Sau đó dùng vòng lặp duyệt qua và kiểm tra
		for (String id : allWindowIDs) {
			if (!id.equals(SeleniumPageWindow)) {
				driver.switchTo().window(id);
			}
			
		}
		sleepInSecond(5);
		
		//Verify title google
		Assert.assertEquals(driver.getTitle(), "Google");	
		// Vì sao dùng hàm này lại lấy ra được ID của tab goole
		String googlePageWindow  = driver.getWindowHandle();
		// Chuyển sang tab Selenium
		switchToWindow(googlePageWindow);
		sleepInSecond(5);
		
//		// Click vào FACEBOOK để bật ra 1 tab mới
//		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
//		sleepInSecond(4);
//		//Verify title google
//		Assert.assertEquals(driver.getTitle(), "Facebook - Đăng nhập hoặc đăng ký");
//		String facebookID = driver.getWindowHandle();
//		
//		driver.switchTo().window(SeleniumPageWindow);	
		// Nếu như ID khác ID của parent thì switch qua 		
		// 2 - Nó sẽ lấy ra tất cả ID
//		Set<String> allWindowIDs = driver.getWindowHandles();// Set ko cho phép trùng		
//		List<WebElement> checkbox = driver.findElements(By.xpath(""));
//		List cho phép trùng/null		
//		Case 1: Chỉ có 2 Window hoặc 2 tab	
//		Case 2: Nhiều hơn 2 window hoặc 2 tab		
	}

	@Test
	public void TC_02_Title() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(5);
		
		// Click vào google để bật ra 1 tab mới
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(4);	
		switchToWindowbyTitle("Google");
		//Verify title google
		Assert.assertEquals(driver.getTitle(), "Google");	
		
		switchToWindowbyTitle("Selenium WebDriver");
		
//		Click vào FACEBOOK
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		sleepInSecond(4);
		switchToWindowbyTitle("Facebook - Đăng nhập hoặc đăng ký");
		Assert.assertEquals(driver.getTitle(), "Facebook - Đăng nhập hoặc đăng ký");
		
		switchToWindowbyTitle("Selenium WebDriver");
		
//		Click vào TIKI
		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
		sleepInSecond(4);
		switchToWindowbyTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		Assert.assertEquals(driver.getTitle(), "Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		
	}


	public void TC_03_Form() {
		
	}
	
//	Dùng được cho duy nhất 2 ID (Window/Tab)
	public void switchToWindow(String otherID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			if (!id.equals(otherID)) {
				driver.switchTo().window(id);
			}
		}
	}
	
//	Dùng được cho tư 2 ID trở lên (Window/Tab)
	public void switchToWindowbyTitle(String expectedPageTile) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			//Switch từng ID trước
			driver.switchTo().window(id);
			
			//Lấy ra title của page này
			String actualPageTitle = driver.getTitle();
			
			if (actualPageTitle.equals(expectedPageTile)) {
				sleepInSecond(5);
				break;
				
			}
		}
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
