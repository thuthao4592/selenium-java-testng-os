package java_basic;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	//@Test
	public void TC_01_For() {
	for (int i = 0; i <=10 ; i++) {
		System.out.println(i);
	}
		
	// Array
	// Với Array/ List/ Set/ Queue (index) bắt đầu từ 0
	String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
	
	// For kết hợp với if: Thỏa mãn điều kiện mới action
	// Có 1 biến đếm - điều kiện để filter 
	// Dùng break: Khi điều kiện thỏa mãn sẽ dừng lại và thoát khỏi vòng lặp
		for (int i = 0; i < cityName.length; i++) {
			if(cityName[i].equals("Da Nang")) {
				System.out.println("Exactly");	
			break;
		}
		
	}
	
	// Dùng để chạy qua hết tất cả các giá trị 
		for (String city : cityName) {
			System.out.println(city);		
		}
		
	}
	
	@Test
	public void TC_02_For_Each() {
		String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
		
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());
		
		// Compile khi coding
		cityAddress.add("Sa Pa");
		cityAddress.add("Ha Giang");
		cityAddress.add("Thai Binh");
		System.out.println(cityAddress.size());
		
		// Runtime (Running)
		for (String city : cityName) {
			cityAddress.add(city);
		}
		System.out.println(cityAddress.size());
		
		for (String cityAdd : cityAddress) {
			System.out.println(cityAdd);
			
		}
	}

}
