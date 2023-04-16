package javaTester;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_And_Or {
	WebDriver driver;
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationfc.github.io/basic-form/");
		
	}

	@Test
	public void TC_01(){
		//OR
		driver.findElement(By.xpath("//h5[text()='Michael Jackson' or @id='eight']")).getText();	

		//and
		driver.findElement(By.xpath("//h5[text()='Michael Jackson' and @id='seven']")).getText();	

	
	}
	
	
}
