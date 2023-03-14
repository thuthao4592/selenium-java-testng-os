package javaTester;

public class Topic_01_System {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		String osName = System.getProperty("os.name");
	
//Đường dẫn project
		System.out.println(projectPath);
//Hệ điều hành
		System.out.println(osName);
		if (osName.contains("Windows")) {
//			Dùng cho windows
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
//			Dùng cho Mac
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

	}

}
