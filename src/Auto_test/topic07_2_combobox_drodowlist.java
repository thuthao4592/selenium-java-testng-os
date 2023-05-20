package Auto_test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class topic07_2_combobox_drodowlist {
	WebDriver driver;
	WebDriverWait exDriverWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, emailAdrdess, companyName, passWord, day, month, year;
	String countryName,provinceName, cityName, Address1, postalCode, PhoneNumber; 

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Xuống dòng 1 loạt crt_shift_F
		firstName = "Automation";
		lastName = "FC";
		emailAdrdess = "automationFC" + getRandomNumber() + "@gmail.net" ;
		companyName = "Mapu";
		passWord = "123456789";
		day = "4";
		month = "September";
		year = "1990";
		
		countryName = "United States";
		provinceName = "Ohio";
		cityName = "Columbus";
		Address1 = "123 PO";
		postalCode = "43085";
		PhoneNumber = "+16146457805";
		
	}
	public int getRandomNumber() {
		Random rand= new Random();
		return rand.nextInt(9999);
		
	}

	@Test 
	public void TC_01_register_new_Account() {
		//action
		driver.get ("https://demo.nopcommerce.com/register");
		driver.findElement(By.xpath("//a[@class= 'ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
		
		new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText(day);
		new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
		new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);
	
		//Assert.assertFalse(new Select(driver.findElement(By.name("DateOfBirthDay"))).isMultiple());
		// Neus như dropdown là single  thì hàm này trả về fale
		// Nếu như dropdown là multiple  thì hàm này trả về true
		// Thực tế hàm này không kiểm tra
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAdrdess);
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyName);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passWord);
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(passWord);
		
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class= 'button-1 register-continue-button']")).getText(),"Your registration completed");
		 
		//login lai
		driver.findElement(By.xpath("//a[@class = 'ico-login']")).click();	
		
		driver.findElement(By.xpath("//input[@id= 'Email']")).sendKeys("emailAdrdess");
		driver.findElement(By.xpath("//input[@id= 'Password']")).sendKeys("passWord");
		
		driver.findElement(By.xpath("//button[@class= 'button-1 login-button']")).click();
	
		// vào my ac để veryfi lại
		driver.findElement(By.xpath("//a[@class= 'ico-account']")).click();	

		//Verify
		 Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), firstName);
		 Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), lastName);
 
		 Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
		 Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month);
		 Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year);
		 
		 Assert.assertEquals(driver.findElement(By.name("Company")).getAttribute("value"), companyName);
		 

		
	}

	@Test 
	public void TC_02_Add_Address() {
		driver.findElement(By.xpath("//li[@class='customer-addresses inactive']/a[text()= 'Addresses']")).click();	
		
		driver.findElement(By.xpath("//button[@class='button-1 add-address-button']")).click();		
		
		driver.findElement(By.xpath("//input[@id='Address_FirstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='Address_LastName']")).sendKeys(lastName);
		driver.findElement(By.id("Address_Email")).sendKeys(emailAdrdess);
		driver.findElement(By.id("Address_Company")).sendKeys(companyName);
		new Select(driver.findElement(By.id("Address_CountryId"))).selectByVisibleText(countryName);
		new Select(driver.findElement(By.id("Address_StateProvinceId"))).selectByVisibleText(provinceName);
		
		driver.findElement(By.id("Address_City")).sendKeys(cityName);
		driver.findElement(By.id("Address_Address1")).sendKeys(Address1);
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(postalCode);
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys(PhoneNumber);
		
		 Assert.assertEquals(driver.findElement(By.xpath("//li[@class='name']")).getText(), firstName + " " + lastName);
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='email']")).getText().contains(emailAdrdess));
		 Assert.assertTrue(driver.findElement(By.xpath("//li[@class='phone']")).getText().contains(PhoneNumber));
		 Assert.assertEquals(driver.findElement(By.xpath("//li[@class='company']")).getText(),companyName) ;
		 Assert.assertEquals(driver.findElement(By.xpath("//li[@class='address1']")).getText(),Address1) ;
		 Assert.assertEquals(driver.findElement(By.xpath("//li[@class='city-state-zip']")).getText(), cityName) ;
		 Assert.assertEquals(driver.findElement(By.xpath("//li[@class='city-state-zip']")).getText(), provinceName) ;
		 Assert.assertEquals(driver.findElement(By.xpath("//li[@class='city-state-zip']")).getText(), postalCode) ;
		 Assert.assertEquals(driver.findElement(By.xpath("//li[@class='country']")).getText(),countryName) ;
		 
		 

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

//dropdown
// Default dropdown  HTML của nó là thẻ select và thẻ option
//Custsom dropdown: khác thẻ select/option
//li/ul/div/span...
