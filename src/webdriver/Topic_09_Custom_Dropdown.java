package webdriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	By emailtextbox = By.id("mail");
	By ageUnder18Radio = By.cssSelector("#under_18");
	By educationTextArea = By.cssSelector("#edu");
	By nameuser5txt = By.xpath("//h5[text()='Name: User5']");
	By Password = By.cssSelector("#disable_password");
	By BioTextarea = By.cssSelector("#bio");
	By Developmentcheckbox = By.cssSelector("#development");

	@BeforeClass
	public void beforeClass() {
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		} else {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		}
//		test
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

//		test
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

@Test
	public void TC_01_JQuery() {
		
driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		SelectItemDropDown("span#speed-button", "div.ui-menu-item-wrapper", "Medium");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(),"Medium");

		SelectItemDropDown("span#speed-button", "div.ui-menu-item-wrapper", "Slower");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(),"Slower");
		
		SelectItemDropDown("span#speed-button", "div.ui-menu-item-wrapper", "Faster");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(),"Faster");
	}

	//@Test
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		SelectItemDropDown("i.dropdown.icon", "span.text", "Stevie Feliciano");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Stevie Feliciano");
		SelectItemDropDown("i.dropdown.icon", "span.text", "Matt");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Matt");
		SelectItemDropDown("i.dropdown.icon", "span.text", "Jenny Hess");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Jenny Hess");

	}
	
	//@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		SelectItemDropDown("li.dropdown-toggle", "ul.dropdown-menu a", "First Option");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");
		
		SelectItemDropDown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");
		
		SelectItemDropDown("li.dropdown-toggle", "ul.dropdown-menu a", "Third Option");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");
		

	}

	//@Test
	public void TC_04_Editable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		
		SelectItemDropDown("input.search", "span.text", "Angola");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Angola");
		
		SelectItemDropDown("input.search", "span.text", "American Samoa");
		SleepInsecon(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"American Samoa");
	
		

	}
	public void SelectItemDropDown(String ParentCss, String AllItemCss, String epectedTextitem) {
		// 1- kích vào 1 thẻ bất kì hoặc icon sao cho lấy hết các icon của dropdown
		driver.findElement(By.cssSelector(ParentCss)).click();
		SleepInsecon(3);
		
		// 2- Chờ cho tất cả Item dc load ra thành công
		// Locator lấy để đại diện cho tất cả các item
		// Lấy đến thẻ chứa text
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(AllItemCss)));
		// Đưa hết tất cả itemDropDown vào 1 list
		
		List<WebElement> speedDropDownItems = driver.findElements(By.cssSelector(AllItemCss));
		
		for (WebElement TempItem : speedDropDownItems) {
			String itemtext = TempItem.getText();
			System.out.println(itemtext);
			if (itemtext.trim().equals(epectedTextitem)) {
				// Click vào item đó
				TempItem.click();

				// Thoát ra khỏi vòng lặp
				break;
			}

		}

	}
	
	public void EnterItemSelectItemDropDown(String TextboxCss, String AllItemCss, String epectedTextitem) {
		// 1- Nhập từ khóa, và sổ ra những item tương ứng
		driver.findElement(By.cssSelector(TextboxCss)).clear();
		driver.findElement(By.cssSelector(TextboxCss)).sendKeys(epectedTextitem);
		SleepInsecon(3);
		
		// 2- Chờ cho tất cả Item dc load ra thành công
		// Locator lấy để đại diện cho tất cả các item
		// Lấy đến thẻ chứa text
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(AllItemCss)));
		// Đưa hết tất cả itemDropDown vào 1 list
		
		List<WebElement> speedDropDownItems = driver.findElements(By.cssSelector(AllItemCss));
		
		for (WebElement TempItem : speedDropDownItems) {
			String itemtext = TempItem.getText();
			System.out.println(itemtext);
			if (itemtext.trim().equals(epectedTextitem)) {
				// Click vào item đó
				TempItem.click();

				// Thoát ra khỏi vòng lặp
				break;
			}

		}

	}

	public void SleepInsecon(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
