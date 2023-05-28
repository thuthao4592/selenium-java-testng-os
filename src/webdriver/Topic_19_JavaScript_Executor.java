package webdriver;

import java.util.Random;
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

public class Topic_19_JavaScript_Executor {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		jsExecutor = (JavascriptExecutor) driver;
		}
	
	
	//@Test
	public void TC_01_Tech_Panda() {	
		
		// TRuy cập trang
		navigateToUrlByJS("http://live.techpanda.org/");
		sleepInSecond(5);
		
		// Get domain
		//executeForBrowser("return document.domain;");
		// Get URl
		//executeForBrowser("return document.URL;");
		
		// Verify
		Assert.assertEquals(executeForBrowser("return document.domain;"), "live.techpanda.org");
		Assert.assertEquals(executeForBrowser("return document.URL;"), "http://live.techpanda.org/");
		
		// Open mobile Page
		hightlightElement("//a[text()='Mobile']");
		clickToElementByJS("//a[text()='Mobile']");
		sleepInSecond(3);
		
		// Add sản phẩm vào 1 cart
		hightlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//button");
		clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//button");
		sleepInSecond(3);
		
		// Verify message được  hiển thị
		Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));
		
		// Open Customer Service Page
		hightlightElement("//a[text()='Customer Service']");
		clickToElementByJS("//a[text()='Customer Service']");
		sleepInSecond(3);
		
		// Scroll tới cuối trang
		hightlightElement("//input[@id='newsletter']");
		scrollToElementOnDown("//input[@id='newsletter']");
		sleepInSecond(3);
		
		// Input 1 email hợp lệ vào textbox newsletter
		sendkeyToElementByJS("//input[@id='newsletter']", "dua" + getRandomNumber() + "@gmail.net");
		
		// Click button Subscribe
		hightlightElement("//button[@title='Subscribe']");
		clickToElementByJS("//button[@title='Subscribe']");
		sleepInSecond(3);
		
		// Verify hiển thị 
		Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
		
		// Chuyển qua 1 domain khác
		navigateToUrlByJS("http://demo.guru99.com/v4/");
		sleepInSecond(5);
		
		// Verify domain của trang hiện tại
		Assert.assertEquals(executeForBrowser("return document.domain;"), "demo.guru99.com");

	}

	@Test
	public void TC_02_HTML5_ValidationMessage() {
		navigateToUrlByJS("https://warranty.rode.com/");
		sleepInSecond(5);
		
		String registerButton = "//button[text()=' Register ']";
		String nameTextbox = "//input[@id='name']";
		String emailTextbox = "//input[@id='email']";
		String passwordTextbox = "//input[@id='password']";
		String confirmpasswordTextbox = "//input[@id='password_confirmation']";
		
		
		clickToElementByJS("//a[text()=' Create an Account ']");
		sleepInSecond(2);
		
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getElementValidationMessage(nameTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(nameTextbox, "automationfc");		
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getElementValidationMessage(emailTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(emailTextbox, "auto@test@gmail.com");
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getElementValidationMessage(emailTextbox), "Please enter an email address.");
		
		sendkeyToElementByJS(emailTextbox, "auto@gmail.com");
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getElementValidationMessage(passwordTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(passwordTextbox, "123456789");
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getElementValidationMessage(confirmpasswordTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(passwordTextbox, "123456789");
		
		
		
		
		
		
	}

	//@Test
	public void TC_03_() {
		
	}
	
	
	// Get domain của page
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}
		
	public String getDomainName() {
		return (String) jsExecutor.executeScript("return document.domain;");		
	}
	
	// Get text
	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	// Để mở 1 trang URL/ Truy cập vào 1 trang
	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	// Click vào 1 link  
	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	// Click vào 1 link 
	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}
	
	public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
		jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}
	
	// input vào 1 textbox
	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}
	
	public String getAttributeInDOM(String locator, String attributeName) {
		return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
		return status;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	public int getRandomNumber() {
		return new Random().nextInt(9999);
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
		
	
