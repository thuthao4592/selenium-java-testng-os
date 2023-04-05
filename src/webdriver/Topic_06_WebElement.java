package webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_WebElement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	 
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		
	@Test
	public void TC_01_() {
		WebElement element = driver.findElement(By.className(""));
		
		// Dùng cho các textbox/ textarea/ dropdown (Edittable)
		// Xóa dữ liệu trước khi nhập text
		element.clear();	//*
		
		// Dùng cho các textbox/ textarea/ dropdown (Edittable)
		// Nhập liệu
		element.sendKeys("");	//**
		
		// Dùng click vào button/ link/ checkbox/ radio/ image/...
		element.click();	//**
		
		String searchAttribute = element.getAttribute("placeholder");	//**
		String emailTextboxAttribute = element.getAttribute("value");
		
		// Search store
		
		//GUI: font/ size/ color/ Location/ Position
		element.getCssValue("background-color");	//*
		
		// vị trí của element so với web (bên ngoài)
		Point point = element.getLocation();
		point.x = 324; 	
		point.y = 324;
		
		// kích thước của element (bên trong)
		Dimension size = element.getSize();
		size.getHeight();
		size.getWidth();
		System.out.println(size.height);
		System.out.println(size.width);
		
		// Location + size
		Rectangle re = element.getRect();
		
		
		// Chụp hình bị lỗi khi testcase fail
		element.getScreenshotAs(OutputType.FILE);	//*
		element.getScreenshotAs(OutputType.BASE64);
		element.getScreenshotAs(OutputType.BYTES);
		
		// Lấy ra tên thẻ html của element đó ---> Truyền vào cho 1 locator khác
		String emailTextboxTagname = driver.findElement(By.cssSelector("#Email")).getTagName();
		driver.findElement(By.xpath("//" + emailTextboxTagname + "[@id='email']"));
		element.getTagName();
		
		// Lấy text từ  Error message/ success message/ label/ header
		element.getText();	//**
		
		// Khi nào value cần lấy nằm bên ngoài ---> dùng gettext
		// Khi nào value cần lấy nằm bên trong ---> dùng getAttribute
		
		
		// Dùng để verify xem 1 element hiển thị hay không
		// Phạm vi: Tất cả các element
		Assert.assertTrue(element.isDisplayed());	//**
		Assert.assertFalse(element.isDisplayed());
		
		
		// Dùng để verify xem 1 element có thao tác được hay không
		// Phạm vi: Tất cả các element
		Assert.assertTrue(element.isEnabled());
		Assert.assertFalse(element.isEnabled());
		
		// Dùng để verify xem 1 element được chọn hay chưa
		// Phạm vi: Checkbox/ Radio 
		Assert.assertTrue(element.isSelected());	//*
		Assert.assertFalse(element.isSelected());
				
		element.sendKeys("");
		
		// Các element nằm trong thẻ form
		// Tương ứng với hành vi End User (Enter)
		element.submit();
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
