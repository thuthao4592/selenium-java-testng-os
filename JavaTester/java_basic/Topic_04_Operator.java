package java_basic;

public class Topic_04_Operator {
	
	public static void main(String[] args) {
		int number = 10;
		
		// number = number + 5
		number +=5;
		
		System.out.println(number);
		
		// Lấy phần nguyên
		System.out.println(number / 5);
		
		// Lấy phần dư 15/7 = 2 dư 1
		System.out.println(number % 7);
		
		// In number ra trước: 15
		// ++: Tăng number lên 1 thành 16
		
		System.out.println(number++);
		
		// ++: Tăng number lên 1 thành 17
		// In number: 17
		
		System.out.println(++number);
		
		// In number ra trước: 17
		// ++: Giảm number xuống 1 thành 16
		System.out.println(number--);
		
		// ++: Giảm number xuống 1 thành 15
		// In number: 15
		
		System.out.println(--number);
		
		// in ra 0,1,2
		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}
		
			
		String address = "Hồ Chí Minh";
			
		if (address != "Hà Nội" && address == "Đà Nẵng") {
			System.out.println("Address is not same");
		}
		
		if (address != "Hà Nội" || address == "Đà Nẵng") {
			System.out.println("Address is not same");
		}
		
		if (!(address == "Hà Nội")) {
			System.out.println("Address is not same");
		}
		
		// Tam nguyên = ? :
		boolean status = (address == "Hà Nội") ? true : false;
		System.out.println(status);
		
			
		
	}

}
