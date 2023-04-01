package webdriver;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_WebBrowser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		} else {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		}
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
	// Tương tác với Browser thì sẽ thông qua biến WebDriver	driver
	// Tương tác với Element thì sẽ thông qua biến WebElement	element	
	}

	@Test
	public void TC_01_() {
		
		driver.close();
		driver.getPageSource();
		driver.quit();
		// tìm một element	
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='email']"));		//**
		
		// tìm nhiều element		
		List<WebElement> checkboxes = driver.findElements(By.xpath(""));	//*
	
		//Mở ra một URL
		driver.get("https://www.facebook.com/");	//**
		
		// Trả về URL của page hiện tại	
		Assert.assertEquals(driver.getCurrentUrl(), "https://vi-vn.facebook.com/");	
		
		// Trả về source code HTML của page hiện tại 
		// Verify tương đối
		
		driver.getPageSource();
		Assert.assertTrue(driver.getPageSource().contains("Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của bạn.")); 
		Assert.assertTrue(driver.getPageSource().contains("Facebook giúp bạn kết nối và chia sẻ"));
		
		// Trả về title của page
		Assert.assertEquals(driver.getTitle(), "Facebook - Đăng nhập hoặc đăng ký");
		
		// Lấy ra được ID của Window/ Tab mà driver đang đứng (active)			
		String LoginWindowID = driver.getWindowHandle();	//*
		
		// Lấy ra ID của tất cả Window/ Tab:		
		Set<String> AllIDs = driver.getWindowHandles();		//*
		
		//Cookie/ Cache
		Options opt = driver.manage();
		
		// Login thành công ----> Lưu lại
		opt.getCookies();	//*
		
		Timeouts time = opt.timeouts();
		// Khoảng thời gian chờ element xuất hiện
		time.implicitlyWait(5, TimeUnit.SECONDS); //5s = 5000ms = 5000000µs		//**
		time.implicitlyWait(5000, TimeUnit.MILLISECONDS);
		time.implicitlyWait(5000000, TimeUnit.MICROSECONDS);
		
		// Khoảng thời gian chờ page load xong trong vòng x giây
		time.pageLoadTimeout(5,  TimeUnit.SECONDS);
		
		// Khoảng thời gian chờ script được thực thi xong trong vòng x giây
		time.setScriptTimeout(5, TimeUnit.SECONDS);
		
		Window win = opt.window();
		win.fullscreen();
		win.maximize();		//**
		
		// Test GUI: Font/ Size/ Color/ Position/ Location/...
		// Set position là set trình duyệt nằm ở tọa độ nào so với độ phân giải màn hình của máy 
		win.getPosition();
		// Set size là set kích thước bên trong của trình duyệt 
		win.getSize();
		
		Navigation nav = driver.navigate();
		nav.back();
		nav.refresh();
		nav.forward();
		//2 câu lệnh giống nhau
		nav.to("https://www.facebook.com/");
		driver.get("https://www.facebook.com/");
		
		
		
		TargetLocator tar = driver.switchTo();
		tar.alert();	//*
		tar.frame("");	//*
		tar.window("");		//*
		
		
		
	}

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
