package sel_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Day24ExampleFields {

	public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
			driver.get("https://www.flexiquiz.com/");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
	//find login element
			driver.findElement(By.id("fq-main-menu-auth" )).click();
	//click login with empty fields
			driver.findElement(By.id("loginNow" )).click( );	
			String error_message="The Email / Username field is required.";
		String message	=driver.findElement(By.xpath("//*[@id=\"userNameValidationMessage\"]")).getText();
		
		if(error_message.equals(message)) 
		{
			System.out.println( "Enter valid details");}
			
			else
				{System.out.println("test fail");
		}
}}
