package webdriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_26_Mix_Implicit_Explicit {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	JavascriptExecutor jsExcutor;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();

		}
	
	
	//@Test
	public void TC_01_Element_Found() {	
		// Element có xuất hiện và không cần chờ hết timeout
		// Dù cho set cả 2 loại wait thì không ảnh hưởng
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Implicit Wait: chỉ apply cho việc findElement/ findElements
		// Explicit Wait: cho các điều kiện của element
		
		driver.get("https://www.facebook.com/");
		
		// Explicit Wait
		System.out.println("Thời gian bắt đầu của explicit Wait = " + getTimeStamp() );		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
		System.out.println("Thời gian kết thúc của explicit Wait = " + getTimeStamp() );
		
		//Implicit Wait
		System.out.println("Thời gian bắt đầu của implicit Wait = " + getTimeStamp() );		
		driver.findElement(By.cssSelector("input#email"));
		System.out.println("Thời gian kết thúc của implicit Wait = " + getTimeStamp() );		
		
		
	}

	//@Test
	public void TC_02_Element_Not_Found() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		//Implicit Wait
		System.out.println("Thời gian bắt đầu của implicit Wait = " + getTimeStamp() );	
		
		// Dùng try/catch Block
		try {
			driver.findElement(By.cssSelector("input#matcon"));
		} catch (Exception e) {
			System.out.println("Thời gian kết thúc của implicit Wait = " + getTimeStamp() );
		}
		
		// Output
		// Khi Element not found thì có cơ chế tìm lại element sau mỗi 0.5s
		// Khi hết timeout sẽ đánh fail Testcase này
		// Throw ra 1 exception: NoSuchElement
		
	}

	//@Test
	public void TC_03_Element_Not_Found_Implicit_Explicit() {
		//3.1 - Implicit = Explicit
		//3.1 - Implicit < Explicit
		//3.1 - Implicit = Explicit
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 5);
		
		driver.get("https://www.facebook.com/");
		
		// Explicit Wait
		
		System.out.println("Thời gian bắt đầu của explicit Wait = " + getTimeStamp() );		
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#matcon")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Thời gian kết thúc của explicit Wait = " + getTimeStamp() );
		}
		
	}
	
	//@Test
	public void TC_04_Element_Not_Found_Explicit_By() {
		
		explicitWait = new WebDriverWait(driver, 5);
		
		driver.get("https://www.facebook.com/");
		
		// Explicit - By là tham số nhận vào của hàm explicit - visibleOFElementLocated(By)
		// Implicit = 0
		// Tổng time = Explicit
		
		System.out.println("Thời gian bắt đầu của explicit Wait = " + getTimeStamp() );		
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#matcon")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Thời gian kết thúc của explicit Wait = " + getTimeStamp() );
		}
		
	}
	
	@Test
	public void TC_05_Element_Not_Found_Explicit_Element() {
		
		explicitWait = new WebDriverWait(driver, 5);
		
		driver.get("https://www.facebook.com/");
		
		// Explicit - By là tham số nhận vào của hàm explicit - visibleOFElementLocated(By)
		// Implicit = 0
		// Tổng time = Explicit
		
		System.out.println("Thời gian bắt đầu của explicit Wait = " + getTimeStamp() );		
		try {
			explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#matcon"))));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Thời gian kết thúc của explicit Wait = " + getTimeStamp() );
		}
		
	}
	
	@Test
	public void TC_06_Element_Not_Found_Explicit_Element() {
		
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 5);
		
		driver.get("https://www.facebook.com/");
		
		// Explicit - By là tham số nhận vào của hàm explicit - visibleOFElementLocated(By)
		// Implicit = 0
		// Tổng time = Explicit
		
		System.out.println("Thời gian bắt đầu của explicit Wait = " + getTimeStamp() );		
		try {
			explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#matcon"))));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Thời gian kết thúc của explicit Wait = " + getTimeStamp() );
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
		driver.quit();
	}
	
		// Show ra cái time-stamp tại thời điểm gọi hàm này
		// time-stamp: ngày- giờ- phút - giây
		public String getTimeStamp() {
			Date date = new Date();
			return date.toString();
	
	}
}
		
	
