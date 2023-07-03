package JavaOOp;

public class Topic_03_Method {
	
	void showCarName() {
		System.out.println("Huyndai");
	}
	
	static void showCarColor() {
		System.out.println("Red");
	}

	public static void main(String[] args) {
		// 1 hàm static có thể gọi trong 1 hàm static khác
		showCarColor();
		Topic_03_Method.showCarColor();
		
		// Gọi qua object/instance
		Topic_03_Method mtd = new Topic_03_Method();
		mtd.showCarName();
		
		

	}

}
