package javaTester;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Text {
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
	public void TC_01_Text(){
		// TODO Auto-generated method stub
		
		System.out.println("Khong co khoang trang o dau hoac cuoi");
		System.out.println("     Co khoang trang o dau");
		System.out.println("Co khoang trang o cuoi     ");
		System.out.println("   Co khoang trang o dau hoac cuoi   ");
		System.out.println("\nCo xuong dong o dau");
		System.out.println("Co xuong dong o cuoi\n");
		System.out.println("\tCo tab o dau");
		System.out.println("Co tab o cuoi\t");
		
	
		
		System.out.println("text nam o dau so voi cac the con");
		driver.findElement(By.xpath("(//h5[text()='Michael Jackson'])[1]")).getText();	
		
		System.out.println("text nam o cuoi so voi cac the con");
		driver.findElement(By.xpath("(//h5[text()='Michael Jackson'])[2]")).getText();
		
		System.out.println("text nam o giua so voi cac the con");
		driver.findElement(By.xpath("(//h5[text()='Michael Jackson'])[3]")).getText();	
		
		System.out.println("text nam tren chinh node cha");
		driver.findElement(By.xpath("(//h5[text()='Michael Jackson'])[4]")).getText();	
		
		
		
		
	}
	@Test
	public void TC_02_containText(){
		// TODO Auto-generated method stub
	
		
		System.out.println("  text nam o dau co khoang trang o dau hoac cuoi   ");
		driver.findElement(By.xpath("(//h5[contains(text(),'Michael Jackson')])[1]")).getText();	
		
		System.out.println("text nam trong chinh node do co the co khoang trang, tab o dau or cuoi");
		driver.findElement(By.xpath("(//h5[contains(text(),'Michael Jackson')])[2]")).getText();
		
		System.out.println("text nam o dau va khong co khoang trang");
		driver.findElement(By.xpath("(//h5[contains(text(),'Michael Jackson')])[2]")).getText();
		
		System.out.println("text nam trong chinh node do khong co khoang trang va xuong dong");
		driver.findElement(By.xpath("(//h5[contains(text(),'Michael Jackson')])[2]")).getText();
		
		System.out.println("text nam trong node con cua h5");
		driver.findElement(By.xpath("//span[contains(text(),'Michael Jackson')]")).getText();
		driver.findElement(By.xpath("//span[contains(text(),'(Ignore Me)')]")).getText();

		System.out.println("tim duoc tat ca cac text cua h5");
		driver.findElement(By.xpath("//h5[contains(.,'Michael Jackson')]")).getText();

		
	}
	@Test
	public void TC_03_concatText(){
		
		System.out.println("text nam chinh node do");
		System.out.println("text co khoang trang or xuong dong or tab o dau/cuoi");
		
				
		System.out.println("text nam trong child node o bat ky vi tri nao");
		System.out.println(driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]")).getText());
		
		
		
		
	}
}
