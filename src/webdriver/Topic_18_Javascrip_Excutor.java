package webdriver;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Javascrip_Excutor {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String email;
	Random random;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		random = new Random();
		email = "automation" + random.nextInt() + "@gmail.com";
		jsExecutor = (JavascriptExecutor) driver;
	}
	
@Test
	public void TC_01_RandomPopup1() {
		navigateToUrlByJS("http://live.techpanda.org/");
		sleepInSecond(7);
		Assert.assertEquals(executeForBrowser("return document.domain;"),"live.techpanda.org");
		Assert.assertEquals(executeForBrowser("return document.URL;"), "http://live.techpanda.org/");
		
		hightlightElement("//a[text() = 'Mobile']");
		clickToElementByJS("//a[text() = 'Mobile']");
		sleepInSecond(4);
		
		hightlightElement("//a[text() = 'Samsung Galaxy']/parent::h2/following-sibling::div[@class = 'actions']/button");
		clickToElementByJS("//a[text() = 'Samsung Galaxy']/parent::h2/following-sibling::div[@class = 'actions']/button");
		sleepInSecond(3);
		
		Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));
		
		
		hightlightElement("//a[text() = 'Customer Service']");
		clickToElementByJS("//a[text() = 'Customer Service']");
		sleepInSecond(3);
		
		Assert.assertEquals(executeForBrowser("return document.title;"), "Customer Service");
		
		hightlightElement("//input[@id = 'newsletter']");
		scrollToElementOnDown("//input[@id = 'newsletter']");
		sleepInSecond(3);
		
		sendkeyToElementByJS("//input[@id = 'newsletter']", email);
		
		hightlightElement("//button[@class = 'button']//span[text() = 'Subscribe']");
		clickToElementByJS("//button[@class = 'button']//span[text() = 'Subscribe']");
		sleepInSecond(3);
		
		Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
		
		navigateToUrlByJS("http://demo.guru99.com/v4/");
		
	}


	public void TC_02_RandomPopup2() {
	}

	
	public void sleepInSecond(long miliSecond) {
		try {
			Thread.sleep(miliSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getDomainName() {
		return (String) jsExecutor.executeScript("return document.domain;");
	}
	
	
	public String getURL() {
		return (String) jsExecutor.executeScript("return document.URL;");
	}
	
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

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

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

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

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}



}
