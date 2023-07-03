package JavaOOp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_05_This_Super extends BaseOOP {
	// Demo phần this_Super
	private WebDriver driver;
	private long shortTimeout = 15;
	private long longTimeout = 45;
	
	public void setImplicitWait() {
		// Dùng supper sẽ gọi property longTimeout của cha (BaseOOP), không dùng longTimeout của con (Topic_05_This_Super)
		// Trong class con và class cha đều có 1 biến cùng tên 
		// Nếu không dùng supper thì sẽ gọi biến của con thay vì gọi biến của cha
		// Biến của cha
		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
		// Biến của con
		driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(this.shortTimeout, TimeUnit.SECONDS);		
	}
	
	public void clickToElement() {
		// Không dùng super thì nó sẽ gọi hàm ở lớp con (BaseOOP)
		setImplicitWait();
		// Dùng super thì nó sẽ gọi hàm ở lớp cha
		super.setImplicitWait();
	}
	
	private int firstNumber;
	private int secondNumber;

	
	// Constructor 1	
	public Topic_05_This_Super() {
		// Từ 1 constructor gọi hàm khởi tạo (constructor) của lớp hiện tại
		// Đứng ở đầu, không đứng  sau 1 dòng lệnh khác		
		//this(10, 15);
		//System.out.println("Hello");	
		
		// Luôn gọi qua Constructor của class cha
		// Khi có nhiều constructor thì dùng super có thể tùy chọn dùng constructor nào trong các constructor của cha		
		// Trong trường hợp class cha chỉ có 1 constructor thì không dùng super
		// Chỉ được gọi 1 super
		// Nếu thằng cha không có bất kỳ 1 constructor nào thì sẽ gọi qua constructor mặc định của thằng cha
		// Nếu thằng cha có ít nhất 1 constructor thì constructor của thằng con phải dùng super để gọi 1 constructor của thằng cha
		super(15);		
		System.out.println("Constructor của Class con");
	}	
	
	// Constructor 2
	public Topic_05_This_Super(int firstNumber, int secondNumber) {
		// This: Tham chiếu tới biến của lớp hiện tại
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}
	
	public void showNumber() {
		// This: gọi phương thức/ method của lớp hiện tại
		this.sumNumber();
	}

	
	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super();
		topic.sumNumber();

	}

}
