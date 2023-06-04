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
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitWait =  new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
	}

	//@Test
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		selectItemInDropdown("span#speed-button", "ul#speed-menu div[role='option']", "Fast");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText()
, "Fast");
		
		
		selectItemInDropdown("span#speed-button", "ul#speed-menu div[role='option']", "Slower");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText()
				, "Slower");
		
		selectItemInDropdown("span#speed-button", "ul#speed-menu div[role='option']", "Faster");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText()
				, "Faster");
		
		selectItemInDropdown("span#salutation-button", "ul#salutation-menu div[role='option']", "Prof.");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText()
				, "Prof.");
		
	}

	//@Test
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

		selectItemInDropdown("i.dropdown.icon", "span.text", "Stevie Feliciano");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Stevie Feliciano");
		
		
		selectItemInDropdown("i.dropdown.icon", "span.text", "Elliot Fu");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Elliot Fu");

		
		selectItemInDropdown("i.dropdown.icon", "span.text", "Christian");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Christian");

	}
	
	//@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");

		selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");

		
		selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "First Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");

		
		selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Third Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");

	
	}
	
	@Test
	public void TC_04_Editable() {

		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

		enterAndSelectInDropdown("input.search", "span.text", "Angola");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Angola");

		enterAndSelectInDropdown("input.search", "span.text", "Australia");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Australia");

		
		enterAndSelectInDropdown("input.search", "span.text", "Belgium");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Belgium");

	
	}
	
	
	public void selectItemInDropdown(String parentCss, String allItemCss, String expectedTextItem) {
		// 1 - Click vào 1 thẻ bất kỳ để làm sao cho nó xổ ra hết các item của dropdown
				driver.findElement(By.cssSelector(parentCss)).click();
				sleepInSecond(1);
				
				// 2 - CHờ cho tất cả các item được load ra thành công
				explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));
				
				// Đưa hết tất cả item trong dropdown vào 1 list
				List<WebElement> speedDropdownItems= explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));

			 
				
				// 3- Tìm item xem đúng cái đang cần hay không (dùng vòng lặp duyệt qua)
				for (WebElement tempItem : speedDropdownItems) {
					
					// 4- Kiểm tra cái text của item đúng với cái mình mong muốn
					if(tempItem.getText().trim().equals(expectedTextItem)) {
						// 5 - Click vào item đó
						tempItem.click();
						
						// Thoát ra khỏi vòng lặp không xét cho các case còn lại nữa
						break;
					}
				}
					
	}
	
	
	public void enterAndSelectInDropdown(String textboxCss, String allItemCss, String expectedTextItem) {
				// 1 - Nhap exxpected item - xo ra tat ca cac item matching
				driver.findElement(By.cssSelector(textboxCss)).clear();
				driver.findElement(By.cssSelector(textboxCss)).sendKeys(expectedTextItem);;
				sleepInSecond(1);
				
				// 2 - CHờ cho tất cả các item được load ra thành công
				explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));
				
				// Đưa hết tất cả item trong dropdown vào 1 list
				List<WebElement> speedDropdownItems= explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));

			 
				
				// 3- Tìm item xem đúng cái đang cần hay không (dùng vòng lặp duyệt qua)
				for (WebElement tempItem : speedDropdownItems) {
					
					// 4- Kiểm tra cái text của item đúng với cái mình mong muốn
					if(tempItem.getText().trim().equals(expectedTextItem)) {
						// 5 - Click vào item đó
						tempItem.click();
						
						// Thoát ra khỏi vòng lặp không xét cho các case còn lại nữa
						break;
					}
				}
					
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
