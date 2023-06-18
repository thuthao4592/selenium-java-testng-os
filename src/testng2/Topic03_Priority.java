package testng2;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Topic03_Priority {
  
	  @Test(enabled = false, description = "JIRA_0787-Create a new Employee and verify the employee create")
	  public void EndUser_01_Create_New_Employee() {
	  }
	  
	  @Test(enabled = false)
	  public void EndUser_02_View_Employee() {
	  }
	  
	  @Test
	  public void EndUser_03_Edit_Employee() {
	  }
	  
	  @Test(enabled = false)
	  public void EndUser_04_Move_Employee() {
	  }
	  

}
