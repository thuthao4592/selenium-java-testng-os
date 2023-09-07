package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Upload_File_1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;


	String nameAnh1 = "andrei-caliman-G4fmKhoO9AI-unsplash.jpg";
	String nameAnh2 = "AnyConv.com__1 (1).jpeg";
	String nameAnh3 = "d2825a9e720bbd55e41a.jpg";
	
	String pathAnh1 = projectPath + "\\Files\\" + nameAnh1;
	String pathAnh2 = projectPath + "\\Files\\" + nameAnh2;
	String pathAnh3 = projectPath + "\\Files\\" + nameAnh3;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath+ "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void TC_01_One_File_Per_Time() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		sleepInSecond(2);
		
		//Upload file thành công
		driver.findElement(By.xpath("//input[@name = 'files[]']")).sendKeys(pathAnh1);
		sleepInSecond(2);
		driver.findElement(By.xpath("//input[@name = 'files[]']")).sendKeys(pathAnh2);
		sleepInSecond(2);
		driver.findElement(By.xpath("//input[@name = 'files[]']")).sendKeys(pathAnh3);
		sleepInSecond(2);
		
		//Verify load ảnh thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + nameAnh1 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + nameAnh2 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + nameAnh3 + "']")).isDisplayed());
		
		//Start ảnh
		List<WebElement> listbtnStart = driver.findElements(By.xpath("//button[@class = 'btn btn-primary start']//span[text()='Start']"));
		for (WebElement button : listbtnStart) {
			button.click();
			sleepInSecond(4);
		}
		
		//Verify Upload file thành công
		Assert.assertTrue(isImageLoaded("//img[contains(@src , '" + nameAnh1 + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src , '" + nameAnh2 + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src , '" + nameAnh3 + "')]"));	
	}

	@Test
	public void TC_02_Multi_File_Per_Time() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		sleepInSecond(2);
		
		//Upload file thành công
		driver.findElement(By.xpath("//input[@name = 'files[]']")).sendKeys(pathAnh1 + "\n" +  pathAnh2  + "\n" + pathAnh3);
		sleepInSecond(2);
		
		//Verify load ảnh thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + nameAnh1 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + nameAnh2 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + nameAnh3 + "']")).isDisplayed());
		
		//Start ảnh
		List<WebElement> listbtnStart = driver.findElements(By.xpath("//button[@class = 'btn btn-primary start']//span[text()='Start']"));
		for (WebElement button : listbtnStart) {
			button.click();
			sleepInSecond(4);
		}
		
		//Verify Upload file thành công
		Assert.assertTrue(isImageLoaded("//img[contains(@src , '" + nameAnh1 + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src , '" + nameAnh2 + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src , '" + nameAnh3 + "')]"));	
		
	}

	public void TC_03_Form() {
		
	}
	
	public void sleepInSecond(long miliSecond) {
		try {
			Thread.sleep(miliSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
		return status;
	}
	
	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
