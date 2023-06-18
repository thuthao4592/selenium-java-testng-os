package testng2;

import org.testng.Assert;

public class Topic00_Assert {

	public static void main(String[] args) {
		String fullName = "Automation Testing";
		// Mong đợi một điều kiện trả về là đúng (true)
		Assert.assertTrue(fullName.contains("Automation"));

		// Mong đợi một điều kiện trả về là sai (false)
		Assert.assertFalse(fullName.contains("Manual"));
		
		// Mong đợi 2 điều kiện bằng nhau
		// Expected result and Actual result bằng nhau
		Assert.assertEquals(fullName, "Automation Testing");
		
		
		
		
	}

}
