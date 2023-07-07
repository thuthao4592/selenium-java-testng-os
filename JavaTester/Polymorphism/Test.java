package Polymorphism;

public class Test {

	public static void main(String[] args) {
		// đa hình trong lúc runtime
		Animal ani = new Animal();
		ani.eat();
		
		ani = new Pig();
		ani.eat();
		
		ani = new Bird();
		ani.eat();
	}

}
