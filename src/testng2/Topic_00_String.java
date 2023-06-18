package testng2;

public class Topic_00_String {
	public static void main(String[] args) {
	String url = "http://the-internet.herokuapp.com/basic_auth";
	String username = "admin";
	String password = "admin";
	
	System.out.println(url);
	
	String[] arrayurl = url.split("//");
	// 1 - http:  -> Index = 0
	// 2 - the-internet.herokuapp.com/basic_auth -> Index = 1
	
	url = arrayurl[0] + "//" + username + ":" + password + "@" + arrayurl[1];

	System.out.println(url);
	
	String firstName = "automation";
	String lastName = "fc";
	System.out.println(firstName + " " + lastName);
	System.out.println(firstName.concat(" ").concat(lastName));
			
}

}
