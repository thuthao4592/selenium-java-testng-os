package javaTester;

import java.util.Random;

public class Topic_05_Random {

	public static void main(String[] args) {
		
		//utilities= tiện ích
		// Data type: class/interface...
		Random rand = new Random();
		System.out.println(rand.nextFloat());
		System.out.println(rand.nextDouble());
		System.out.println(rand.nextInt());
		System.out.println(rand.nextInt(99999));
		System.out.println(rand.nextInt(9999));
		System.out.println(rand.nextInt(999));
		System.out.println("automation"+ rand.nextInt(999) +"@gmail.net");
		System.out.println(rand.nextLong());
		

	}

}
