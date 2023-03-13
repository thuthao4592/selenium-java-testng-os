package webdriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Data_Type {

	public static <Interger> void main(String[] args) {
		// TODO Auto-generated method stub
byte bnumber=127;

short snumber=3200;

int inumber=343454345;

long lnumber=234343434;

float studenPoint=9.5f;

double employeeSalry=35.6d;

boolean status=true;//Nam
        status=false;//nữ
char a='A';
FirefoxDriver driver=new FirefoxDriver();

WebElement firtNameTextBox;
String firtname="Automation Testing";
Object peple;
String[] studentName= {"Lê Văn A","Lê Văn B","Lê Văn C"};
List<WebElement> checkboxes= (List<WebElement>) driver.findElement(By.cssSelector(""));
Map<String,Interger> student= new HashMap<String,Interger>();

	}

}
