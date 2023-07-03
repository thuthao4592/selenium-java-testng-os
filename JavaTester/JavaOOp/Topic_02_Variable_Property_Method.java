package JavaOOp;

public class Topic_02_Variable_Property_Method {
	// Global không phải khởi tạo vẫn sử dụng được (do nó có giá trị default)
	int studentNumber;
	float studentPrice;
	String studentCountry;
	boolean studentStatus;
	
	private String studentName = "Mai Anh";	// Global variable
	
	// Static variable: dùng và gán lại được 
	public static String studentAddress = "Ho Chi Minh";
	
	// Dùng trong phạm vi class này (cho tất cả các instance/ object dùng)
	private static String studentPhone = "0978693004";
	
	// Final varibale: không cho phép gán lại/ không override lại
	// Cố định dữ liệu không cho phép thay đổi trong quá trình chạy
	final String country = "Việt Nam";
	
	// Static final variable: hằng số
	// Nó không được ghi đè
	// Có thể truy cập rộng rãi cho tất cả các instance/ thread
	static final float PI_NUMBER = 3.1458322f;	

	// Access Modifier: default
	int studentID = 1000125; // Access Modifier: dạng default (trong package có thể truy cập được)

	// Hàm (method) - static
	public static void main(String[] args) {
		// Local variable - biến cục bộ: hàm
		String studentName = "Mai Anh";
		
		if (studentName.startsWith("Mai")) {
			// Local variable - biến cục bộ: block code
			int number = 100;
			
		// Local variable: bắt buộc phải khởi tạo mới được sử dụng
		int studentNumber;
		float studentPrice;
		String studentCountry;
		boolean studentStatus;
		}
	
	}
	
	// Constructor
	public Topic_02_Variable_Property_Method() {
		// Local variable - biến cục bộ: constructor
		String studentName = "Mai Anh";
	}
	
	// Hàm (method) - non static
	public void display() {
		// Local variable - biến cục bộ: hàm 
		String studentName = "Mai Anh";
	}

}
