package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_25_ExplicitWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	
	String beachFileName = "beach.jpg";
	String sunsetFileName = "sun_set.jpg";
	String catFileName = "cat.jpg";
	
	String beachFilePath = projectPath + "\\Upload_file\\" + beachFileName;
	String sunsetFilePath = projectPath + "\\Upload_file\\" + sunsetFileName;
	String catFilePath = projectPath + "\\Upload_file\\" + catFileName;
	
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
	public void TC_01_Visible() {		
		driver.get("https://automationfc.github.io/dynamic-loading/");	
		
		explicitWait = new WebDriverWait(driver, 5);
		
		// Click vào Start button
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
	
		// Get text và verify
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	
	}

	//@Test
	public void TC_02_Invisible() {		
		driver.get("https://automationfc.github.io/dynamic-loading/");	
		
		explicitWait = new WebDriverWait(driver, 5);
		
		// Click vào Start button
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		// Wait cho loading icon biến mất		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
	
		// Get text và verify
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	
	}
	
	//@Test
	public void TC_03_Ajax_Loading() {
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		explicitWait = new WebDriverWait(driver, 15);
		
		// Wait cho Date Picker được hiển thị 
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.RadCalendar")));
		
		// Verify cho Selected Dates là không có ngày nào được chọn
		Assert.assertEquals(driver.findElement(By.cssSelector("div.RadAjaxPanel>span")).getText(), "No Selected Dates to display.");
		
		// Wait cho ngày 4/6 được phép click
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='4']")));
		
		// Click vào ngày 4/6
		driver.findElement(By.xpath("//a[text()='4']")).click();
		
		// Wait cho Ajax icon biến mất (dùng hàm invisible)
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
		
		// Wait cho ngày vừa được chọn là được phép click trở lại 
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='rcSelected']/a[text()='4']")));
		
		// Verify cho ngày Selected Date là "Sunday, June 4, 2023"
		Assert.assertEquals(driver.findElement(By.cssSelector("div.RadAjaxPanel>span")).getText(), "Sunday, June 4, 2023");
		
	}
	
	@Test
	public void TC_04_Upload_File() {
		driver.get("https://gofile.io/uploadFiles");
		
		explicitWait = new WebDriverWait(driver, 45);
		
		// Wait cho Add Files button visible
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#filesUpload button.filesUploadButton")));
		
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(beachFilePath + "\n" + sunsetFilePath + "\n" + catFilePath );
		
		// Wait cho các loading icon của từng file biến mất
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.mainUploadFilesList div.progress"))));
		
		// Wait + Verify message hiển thị
		Assert.assertEquals(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.text-center div.border-success"))).getText(), "Your files have been successfully uploaded");
	
		// Wait + click cho download link được phép click
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink"))).click();
		
		// Wait + verify luôn cho file Name với button download hiển thị
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + beachFileName +"']/parent::a/parent::div/following-sibling::div//span[text()='Download']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + sunsetFileName +"']/parent::a/parent::div/following-sibling::div//span[text()='Download']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + catFileName +"']/parent::a/parent::div/following-sibling::div//span[text()='Download']"))).isDisplayed());
	
		// Wait + verify luôn cho file Name với button play hiển thị
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + beachFileName + "']/parent::a/parent::div/following-sibling::div//button[contains(@class,'filesContentOptionPlay')]"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + sunsetFileName + "']/parent::a/parent::div/following-sibling::div//button[contains(@class,'filesContentOptionPlay')]"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + catFileName + "']/parent::a/parent::div/following-sibling::div//button[contains(@class,'filesContentOptionPlay')]"))).isDisplayed());
	
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
		
	
