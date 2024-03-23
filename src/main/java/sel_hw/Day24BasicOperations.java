package sel_hw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day24BasicOperations {

	public static WebDriver openBrowser() {

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flexiquiz.com/");
		
		return driver;
	}

}
