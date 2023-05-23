package webdriver;

import java.util.Random;
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

public class Topic_16_Popup_PartIII_Random_Popup_IN_AND_NOT_IN_DOM {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String emailAdress = "testdemo" + getRandomNumber() +"@gmail.com";
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
	
	// Yêu cầu: 
	// Random popup nên nó có thể hiển thị một cách ngẫu nhiên hoặc không hiển thị
	// Nếu như nó hiển thị thì mình cần thao tác lên popup  --> Đóng nó đi để qua step tiếp theo
	// Nếu như nó không hiển thị thì qua step tiếp theo luôn
	
	
	@Test
	public void TC_01_Random_In_Dom_Java_Code_Geeks() {
		driver.get("https://www.javacodegeeks.com/");
		sleepInSecond(30);
		
		By lePopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");
		
		// Vì nó luôn có trong DOM nên có thể sử dụng hàm isDisplayed() để kiểm tra được
		if(driver.findElement(lePopup).isDisplayed()) {
			// Nhập email vào
			driver.findElement(By.cssSelector("div.lepopup-input>input")).sendKeys(emailAdress);
			sleepInSecond(3);
			driver.findElement(By.cssSelector("a[data-label='OK'],[data-label='Get the Books']>span")).click();
			sleepInSecond(5);
			
			// Verify
			Assert.assertEquals(driver.findElement(By.cssSelector("div.lepopup-element-html-content>h4")).getText(), "Thank you!");
			Assert.assertTrue(driver.findElement(By.cssSelector("div.lepopup-element-html-content>p")).getText().contains("Your sign-up request was successful"));

			// Đóng popup đi ---> Qua step tiếp theo
			
			// Sau 5s thì nó sẽ tự đóng popup
			sleepInSecond(15);
			
		}
		
		String articleName = "Agile Testing Explained";
			// Qua step này
			driver.findElement(By.cssSelector("input#search-input")).sendKeys(articleName);
			driver.findElement(By.cssSelector("button#search-submit")).click();
			sleepInSecond(7);
			
			Assert.assertEquals(driver.findElement(By.cssSelector("ul#posts-container>li:first-child h2 a")).getText(), articleName);
		}
	
	@Test
	public void TC_02_Random_In_Dom_VNK_Edu() {
		driver.get("https://vnk.edu.vn/");
		sleepInSecond(30);
		
		By Popup = By.cssSelector("div[data-tl-type='lightbox']");
		
		if (driver.findElement(Popup).isDisplayed()) {
			// Close popup này
			driver.findElement(By.cssSelector("svg.tcb-icon")).click();
			sleepInSecond(3);
		}
		
		driver.findElement(By.xpath("//button[text()='Danh sách khóa học']")).click();
		sleepInSecond(5);
		
		Assert.assertEquals(driver.getTitle(), "Lịch khai giảng các khóa học tại VNK EDU | VNK EDU");
	
	}

	@Test
	public void TC_03_Random_Not_In_Dom_De_Hieu() {
		driver.get("https://dehieu.vn/");
		sleepInSecond(10);
		
		By popup = By.cssSelector("div.popup-content");

	// findElement  --> Sẽ bị fail khi không tìm thấy Element ---> Ném ra 1 ngoại lệ: NoSuchElementException
	// findElements ---> không bị fail khi không tìm thấy Element ---> Trả về 1 list rỗng (empty)
	
	// isDisplay()	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if (driver.findElements(popup).size()>0 && driver.findElements(popup).get(0).isDisplayed()) {
			driver.findElement(By.id("popup-name")).sendKeys("automation");
			driver.findElement(By.id("popup-email")).sendKeys("fc");
			driver.findElement(By.id("popup-phone")).sendKeys("0978452123");
			sleepInSecond(7);
			
			driver.findElement(By.cssSelector("button.close")).click();
			
		}
		
	driver.findElement(By.xpath("//a[text()='Tất cả khóa học']")).click();	
	sleepInSecond(3);
	
	String courseName = "Khóa học Thiết kế và Thi công Hệ thống BMS";
	driver.findElement(By.id("search-courses")).sendKeys(courseName);
	driver.findElement(By.id("search-course-button")).click();
	sleepInSecond(3);
	
	Assert.assertEquals(driver.findElements(By.cssSelector("div.course")).size(), 1);
	Assert.assertEquals(driver.findElement(By.cssSelector("div.course-content>h4")).getText(), "Khóa học Thiết kế và Thi công Hệ thống BMS");

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
	
	public int getRandomNumber() {
		return new Random().nextInt(99999);
	}
}
		
	
