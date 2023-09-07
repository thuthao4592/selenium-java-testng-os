package webdriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait expliciWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		expliciWait = new WebDriverWait(driver, 30);
//		Chờ đến 30s thì timeout
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_JQuery() {
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
	
//		1. Click vào 1 thẻ bất kỳ để làm sao cho nó xổ ra hết các item
		driver.findElement(By.id("speed-button")).click();
//		2. Chờ cho tất cả các item được load ra thành công
//		Locator phải lấy để đại diện cho tất cả các item
//		Lấy đến thẻ chưa text
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='speed-menu']//div[@role='option']")));
		
//		Đưa hết tất cả item trong droplist vào trong 1 list
		List<WebElement> speedDropdownItems =  driver.findElements(By.xpath("//ul[@id='speed-menu']//div[@role='option']"));
//		3. Tìm item xem đúng cái dạng đang cần hay ko
		for (WebElement item : speedDropdownItems) {
			String itemtext = item.getText();
			System.out.println(itemtext);
			
//			4. Kiểm tra cái text của item đúng vs cái mình mong muốn
			if (itemtext.equals("Slow")) {
				System.out.println("Click vào item");
//				5. Click vào irtem đó
				item.click();
				driver.findElement(By.id("speed-button")).click();
			} else {
				System.out.println("Không click vào item");
			}	
		}
	}

//	@Test
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//div[@role='listbox']")).click();
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='text']")));
		List<WebElement> listName = driver.findElements(By.xpath("//span[@class='text']"));
		for (WebElement item : listName) {
			String itemtext = item.getText();
			if (itemtext.trim().equals("Justen Kitsune")) {
				System.out.println("Click vào Justen Kitsune");
				item.click();
			}
		}
		
	}
	
//	@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		sleepInSecond(3);
		
		getSelectOption("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "Second Option");
		
	}

	@Test
	public void TC_04_Editable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		sleepInSecond(3);
		
		enterSelectOption("//input[@class='search']", "//div[@role='listbox']//div", "Angola", "Ang");
		
	}
	
	public void sleepInSecond(long miliSecond) {
		try {
			Thread.sleep(miliSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void getSelectOption(String clickFatherCss, String allItemCss, String expectedItem) {
//		1. Click vào 1 thẻ bất kỳ để làm sao cho nó xổ ra hết các item
		driver.findElement(By.xpath(clickFatherCss)).click();
		
//		2. Chờ cho tất cả các item được load ra thành công
//		Locator phải lấy để đại diện cho tất cả các item
//		Lấy đến thẻ chưa text
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemCss)));
		
//		Đưa hết tất cả item trong droplist vào trong 1 list
		List<WebElement> listName = driver.findElements(By.xpath(allItemCss));
		
		
		for (WebElement item : listName) {
			String itemtext = item.getText();
			
//			4. Kiểm tra cái text của item đúng vs cái mình mong muốn
			if (itemtext.trim().equals(expectedItem)) {
				System.out.println("Click vào" + expectedItem);
				
//				5. Click vào irtem đó
				item.click();
				break;
			}
		}
	}

	public void enterSelectOption(String clickFatherCss, String allItemCss, String expectedItem, String enterItem) {
//		1. Click vào 1 thẻ bất kỳ để làm sao cho nó xổ ra hết các item
		driver.findElement(By.xpath(clickFatherCss)).sendKeys(enterItem);;
		
//		2. Chờ cho tất cả các item được load ra thành công
//		Locator phải lấy để đại diện cho tất cả các item
//		Lấy đến thẻ chưa text
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemCss)));
		
//		Đưa hết tất cả item trong droplist vào trong 1 list
		List<WebElement> listName = driver.findElements(By.xpath(allItemCss));
		
		
		for (WebElement item : listName) {
			String itemtext = item.getText();
			
//			4. Kiểm tra cái text của item đúng vs cái mình mong muốn
			if (itemtext.trim().equals(expectedItem)) {
				System.out.println("Click vào" + expectedItem);
				
//				5. Click vào irtem đó
				item.click();
				break;
			}
		}
	}
	
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
