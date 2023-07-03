package JavaOOP_OverLoading;

// Overloading: Các hàm (object) có cùng tên, có thể có cùng số lượng tham số
// 1 - Nếu cùng số lượng tham số phải khác kiểu dữ liệu
// 2 - Nếu khác số lượng tham số thì không quan tâm kiểu dữ liệu
// Ưu tiên số lượng tham số trước rồi mới xét kiểu dữ liệu sau
public class Overloading {
	private int firstNumber;
	private int secondNumber;
	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}
	
	public void sumNumber(int number) {
		System.out.println(number + 100);
	}
	
	public void sumNumber(int firstNumber, int secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}
	
	public void sumNumber(float firstNumber, float secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}
	
	public void sumNumber(int firstNumber, float secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}
	
	public static void main(String[] args) {
		Overloading over = new Overloading();
		// Tính đa hình trong combile code
		over.sumNumber(15);

	}

}
