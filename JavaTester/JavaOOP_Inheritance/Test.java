package JavaOOP_Inheritance;

// Khi không kế thừa cái j thì Test default kế thừa object
// Khi Test kế thừa class Animal thì Test sẽ trở thành kế thừa multiple level, không kế thừa trực tiếp Object nữa  
// Test kế thừa Animal, Animal kế thừa Object
// Không phải Test vừa kế thừa Animal vừa kế thừa Object (vì trong selenium không hỗ trợ đa kế thừa)
public class Test extends Animal {

	public static void main(String[] args) {
		HuskyDog dog = new HuskyDog();
		dog.eat();
		dog.run();
		dog.hun();
		
		// Gọi age thông qua hàm setter và getter, không truy cập trực tiếp tới biến age
		dog.setAge(-15);
		System.out.println(dog.getAge());
		
		Test test = new Test();
		System.out.println(test.toString());
	}
	
	@Override
	public String toString() {
		return "This is a testing class";
	}

}
