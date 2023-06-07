package webdriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Upload_File_AutoIT {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
	
	String beachFileName = "beach.jpg";
	String sunsetFileName = "sun_set.jpg";
	String catFileName = "cat.jpg";
	
	String beachFilePath = projectPath + "\\Upload_file\\" + beachFileName;
	String sunsetFilePath = projectPath + "\\Upload_file\\" + sunsetFileName;
	String catFilePath = projectPath + "\\Upload_file\\" + catFileName;
	
	String autoITFirefoxOneTimePath = projectPath + "\\AutoITScripts\\firefoxUploadOneTime.exe";
	String autoITChromeOneTimePath = projectPath + "\\AutoITScripts\\chromeUploadOneTime.exe";
	String autoITFirefoxMultiplePath = projectPath + "\\AutoITScripts\\firefoxUploadMultiple.exe";
	String autoITChromeMultiplePath = projectPath + "\\AutoITScripts\\chromeUploadMultiple.exe";
	


	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		//driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		jsExecutor = (JavascriptExecutor) driver;
		}
	
	
	@Test
	public void TC_01_One_File_Per_Time() throws IOException {	
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		// click để bật open file dialog
		driver.findElement(By.cssSelector("span.btn-success")).click();
		
		// Load file lên
		if (driver.toString().contains("firefox")) {
			Runtime.getRuntime().exec(new String[] {autoITFirefoxOneTimePath, beachFilePath});	
		} else {
			Runtime.getRuntime().exec(new String[] {autoITChromeOneTimePath, beachFilePath});
		}
		
		// Verify load lên thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + beachFileName + "']")).isDisplayed());
	
		// Click upload
		List<WebElement> uploadButton = driver.findElements(By.cssSelector("table button.start"));
		for (WebElement button : uploadButton) {
			button.click();
			sleepInSecond(5);
		}
		
		// Verify upload thành công (Link)
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + beachFileName + "']")).isDisplayed());
	
		// Verify upload thành công (Image)
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + beachFileName + "')]"));
		
	}

	//@Test
	public void TC_02_Multiple_File_Per_Time() throws IOException {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		// click để bật open file dialog
		driver.findElement(By.cssSelector("span.btn-success")).click();
		
		// Load file lên		
		if (driver.toString().contains("firefox")) {
			Runtime.getRuntime().exec(new String[]{autoITFirefoxMultiplePath, beachFilePath, sunsetFilePath});	
		} else {
			Runtime.getRuntime().exec(new String[]{autoITChromeMultiplePath, beachFilePath, sunsetFilePath});
		}


		// Verify load lên thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + beachFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + sunsetFileName + "']")).isDisplayed());
		
			
		// Click upload
		List<WebElement> uploadButton = driver.findElements(By.cssSelector("table button.start"));
		for (WebElement button : uploadButton) {
			button.click();
			sleepInSecond(5);
		}
		
		// Verify upload thành công (Link)
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + beachFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + sunsetFileName + "']")).isDisplayed());
		

		// Verify upload thành công (Image)
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + beachFileName + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + sunsetFileName + "')]"));
		
	
	}

	//@Test
	public void TC_03_() {
		
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
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
		//driver.quit();
	}
}
		
	
