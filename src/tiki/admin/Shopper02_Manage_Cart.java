package tiki.admin;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Shopper02_Manage_Cart {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		
	
		@BeforeTest(alwaysRun = true)
			public void initBrowser() {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	  
	  @Test(groups = {"admin","cart"})
	  public void Cart_01_Create_Visa() {
	  }
	  
	  @Test(groups = {"admin","cart"})
	  public void Cart_02_View_Visa() {
	  }
	  
	  @Test(groups = {"admin","cart"})
	  public void Cart_03_Update_Visa() {
	  }
	  
	  @Test(groups = {"admin","cart"})
	  public void Cart_04_Delete_Visa() {
	  }
	  
	  @AfterTest(alwaysRun = true)
	  	public void cleanBrowser() {
		  driver.quit();		  
	  }
}
