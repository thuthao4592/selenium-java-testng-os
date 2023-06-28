package java_basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	// Primitive type / value type: nguyên thủy
	// Kiểu nguyên thủy không có các function đi theo
	// số nguyên
	byte bNumber = 6;
	short sNumber = 15000;
	int iNumber = 65000;
	long lNumber = 6500 ;
	
	// Số thực
	float fNumber = 12.34f;
	double dNumber = 13.25d;
	
	char cChar = '1';
	boolean bStatus = true;
	
	// Reference type / value type: tham chiếu
	// Kiểu tham chiếu sẽ có function đi theo
	// 1- String
	String address = "Hồ Chí Minh";
	
	// 2- Array
	String[] studentAddress = {address, "Hà Nội", "Đà Nẵng"};
	Integer[] studentNumber = {15, 20, 3};
	
	// 3- Class
	Topic_02_Data_Type topic;
	
	// 4- Interface
	WebDriver driver;
	
	// 5- Object
	Object aObject;
	
	// 6-Collection- List/Set/Queue/Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();	
	List<String> productName = new ArrayList<String>();
	
	public void clickToElement() {
	// Kiểu tham chiếu sẽ có function đi theo
		address.trim();
	}
		
	
	public static void main(String[] args) {
	

	}

}
