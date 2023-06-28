package java_basic;

import java.util.Scanner;

public class Topic_01_Variable {
	// Khai báo biến ở đây thì sẽ là global variable
	// Không gán giá trị gì cả thì run sẽ ra default result = 0
	// Phải có giá trị static vì khai báo ngoài hàm pulic static void
	static int number;
	
	// Nếu không muốn dùng static thì phải new 1 cái object
	String address = "Hồ Chí Minh";

	static int studentNumber;
	static boolean statusvalue;
	static final String browserName = "Chrome";
	
	// Biến toàn cục
	static int studentPrice;
	
	String studentName = "AutomationFC";
	
	public static void main(String[] args) {
		// Khai báo trong này thì sẽ là local variable
		// Không gán giá trị gì cả thì nó sẽ báo lỗi vì khai báo biến local variable bắt buộc phải gán giá trị
		// Không phải có giá trị static vì khai báo trong hàm public static void
		int studentNumber = 0;	
		System.out.println(studentNumber);	
		
		//Run sẽ cho ra default result: 0
			System.out.println(number);
			
		// New 1 cái object va truy cap thong qua object
			Topic_01_Variable topic = new Topic_01_Variable();
			System.out.println(topic.address);
		
		
		// Biến toàn cục
		int studentPrice = 5;
		System.out.println(studentPrice);
		
		System.out.println(studentNumber);
		System.out.println(statusvalue);
		System.out.println(Topic_01_Variable.browserName);
		System.out.println(Topic_01_Variable.statusvalue);
		System.out.println(Topic_01_Variable.studentPrice);
		
		Topic_01_Variable topic_01 = new Topic_01_Variable();
		Topic_01_Variable topic_02 = new Topic_01_Variable();
		Topic_01_Variable topic_03 = new Topic_01_Variable();
		
		System.out.println(topic_01.studentName);
		System.out.println(topic_02.studentName);
		System.out.println(topic_03.studentName);
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println(name);
		System.out.print(name);
		
	}

	// Getter: getCurrentUrl/ getTitle/ getText/ getAttribute/getCssValue/ getSize/ getLocation/ getPosition
	public String getStudentName() {
		return this.getStudentName();
		
	}
	
	// Setter: click/sendkey/clear/select/back/forward/refresh/get/...
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
}
