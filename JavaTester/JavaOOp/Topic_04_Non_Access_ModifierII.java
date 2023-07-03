package JavaOOp;

	// abstract class
	public abstract class Topic_04_Non_Access_ModifierII {

	// variable
	// Không define variable là abstract
	String animalName = "Dog";
	
	// astract method
	// Không có phần thân (body)
	// public/ protected
	// Bắt buộc các class con phải overrite hàm này lại
	public abstract void setAnimalName();
	
}
