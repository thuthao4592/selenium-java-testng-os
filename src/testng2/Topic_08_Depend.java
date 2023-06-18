package testng2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_08_Depend {
  @Test
  public void Product_01_Create_Product() {
	  Assert.assertTrue(true);
  }
  
  // Testcase sau thường sẽ depend vào testcase trước
  // Khi testcase 1 bị fail thì các testcase sau tự chuyển sang trạng thái skip
  @Test(dependsOnMethods = "Product_01_Create_Product")
  public void Product_02_View_Product() {
	  Assert.assertTrue(false);
  }
  
  @Test(dependsOnMethods = "Product_02_View_Product")
  public void Product_03_Update_Product() {
  }
  
  @Test(dependsOnMethods = "Product_03_Update_Product")
  public void Product_04_Delete_Product() {
  }
}
