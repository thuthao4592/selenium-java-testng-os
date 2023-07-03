package JavaOOp;
	// Không có static class
public class Topic_04_Non_Access_Modifier {
	// static: variable/ method
	// Có thể gọi vào hàm static vì biến này dó 1 cái class quản lý
	// Dùng cho tất cả các instance/ object
	// Phạm vi: cho toàn bộ system sử dụng
	// Có thể override (gán lại giá trị) được
	// Ngoài class thì sẽ truy cập trực tiếp từ tên class, không cần phải tạo instance/object 
	// Không nên lạm dụng biến static
	// Ex: System.out.println(Topic_04_Non_Access_Modifier.browserName);
	static String browserName = "Chrome";
	
	// non-static: variable/ method
	// Nếu gọi vào hàm static sẽ báo lỗi vì biến này do 1 cái instance quản lý
	// Muốn gọi được thì phải thông qua khai báo 1 cái object/instance
	String serverName = "Testing";
	
	// final Ariable (xem như là 1 hằng số)
	// Nếu không đi kèm với static thì viết kiểu camel Case
	final String colorCar = "black";
	// Đi kèm với static thì viết hoa
	final static float PINUMBER = 3.14f;
	
	public static void main(String[] args) {
		System.out.println(browserName);
		browserName = "Firefox";
		System.out.println(browserName);
		
		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		System.out.println(topic.serverName);
		
		// Đối với final ariable thì không được phép gán lại giá trị
		System.out.println(topic.colorCar);
		
		// Muốn gọi hàm static thì chỉ cần gọi trực tiếp tên hàm
		sendKeyToElement("textbox");
		// Muốn gọi hàm non-static thì phải thông qua khai báo 1 cái object/instance
		topic.clickToElement("Button");
		
	}
	
	// Hàm non-static
	public void clickToElement (String elementName) {
		System.out.println(elementName);
	}
	// Hàm static
	// 1 hàm static có thể gọi trực tiếp đến 1 hàm static khác trong cùng 1 class
	// Ngoài class: gọi thông qua tên class của nó. Ex: Topic_04_Non_Access_Modifier.sendKeyToElement("textbox");
	public static void  sendKeyToElement (String elementName) {
		System.out.println(elementName);
	}
	


}
