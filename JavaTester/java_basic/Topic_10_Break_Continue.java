package java_basic;

public class Topic_10_Break_Continue {

	public static void main(String[] args) {
		for (int i = 1; i <=5; i++) {
			System.out.println("i = " + i);
			
		
		for (int j = 1; j <=5; j++) {
			if (j==4) {
				continue;
			}
			System.out.println("j = " + j);
			}
		}
	}
}
