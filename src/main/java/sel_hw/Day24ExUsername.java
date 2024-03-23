package sel_hw;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day24ExUsername {
	//WORKING EXAMPLE
	static WebDriver driver;
	
	public static void validate(String error_message,String message)
	{
		if(error_message.equals(message)) 
		{
		System.out.println( " test pass-Enter valid details");}
		
		else
			{System.out.println("test fail");	}	
		
	}
	public static void loginWithEmptyFields() {
		
		driver.findElement(By.id("loginNow" )).click( );	
		String error_message="The Email / Username field is required.";
		String message	=driver.findElement(By.xpath("//*[@id=\"userNameValidationMessage\"]")).getText();
	
			validate(error_message,message); //calling static method
			
			if (error_message.equals(message))
			{System.out.println("loggedin with emptyfield");}
		}
	public static void invalidUserNameAndInvalidPassword() {
	
	driver.findElement(By.id("UserName")).sendKeys("aaaa@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("34562");
	driver.findElement(By.id("loginNow" )).click( );
	
	String error_message="The user name or password provided is incorrect.";
	String message=driver.findElement(By.xpath("//*[@id=\"loginControls\"]/form/div[1]")).getText();
	
	validate(error_message,message);
	if (error_message.equals(message))
	{ System.out.println("Invalid user name and invalid Password");}}
	
	
	//public static void validUserNameInvalidPassword() 
	
	public static void ValidUsernameInvalidPassword()  {
	
		driver.findElement(By.id("UserName")).sendKeys("autotesting24@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("34562");
		driver.findElement(By.id("loginNow" )).click( );
		
		String error_message="The user name or password provided is incorrect.";
		String message =driver.findElement(By.xpath("//*[@id=\"loginControls\"]/form/div[1]/ul/li")).getText();
		
		validate(error_message,message);
		if (error_message.equals(message))
		{ System.out.println("Valid user name and invalid Password");}
	}
	
	//with correct user name and space as password.
	
	public static void ValidUsernameBlankPassword()  {
		
		driver.findElement(By.id("UserName")).sendKeys("autotesting24@gmail.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("loginNow" )).click( );
		
		String error_message="The Password field is required.";
		String message= driver.findElement(By.id("passwordValidationMessage")).getText();
		
		validate(error_message,message);
		
		if (error_message.equals(message))
		{ System.out.println("valid user name and  blank Password");}
	
	
}
	
	//with correct user name and no password.
	
		public static void ValidUsernameNoPassword()  {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.findElement(By.id("UserName")).clear();
			driver.findElement(By.id("UserName")).sendKeys("autotesting24@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("");
			driver.findElement(By.id("loginNow" )).click( );
			
			String error_message="The Password field is required.";
			String message= driver.findElement(By.xpath("//*[@id=\"passwordValidationMessage\"]")).getText();
			validate(error_message,message);
			if (error_message.equals(message))
			{ System.out.println("valid user name and  no Password");}}
		
		public static void invalidUsernameAndValidPassword() {
			driver.findElement(By.id("UserName")).clear();
			driver.findElement(By.id("UserName")).sendKeys("autotesting@gmail.com");
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys("Allahabad@24");
			driver.findElement(By.id("loginNow" )).click( );
			String error_message="The user name or password provided is incorrect.";
			String message =driver.findElement(By.xpath("//*[@id=\"loginControls\"]/form/div[1]/ul/li")).getText();
			validate(error_message,message);
			if (error_message.equals(message))
			{ System.out.println("invalid user name and valid Password");}
			
		}
		
		public static void validUsernameAndValidPassword() 
		{    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.id("UserName")).clear();
			driver.findElement(By.id("UserName")).sendKeys("autotesting24@gmail.com");
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys("Allahabad@24");
			driver.findElement(By.id("loginNow" )).click( );
			driver.findElement(By.id("userLogOut"));
			System.out.println("login successful");
		}
		
	public static void main(String[] args) throws InterruptedException {
			
					/* we have written this code in basicoperation class
					 WebDriver driver =new ChromeDriver();
					driver.get("https://www.flexiquiz.com/");	*/
			
		driver= new Day24BasicOperations().openBrowser();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		
		//find login element
		driver.findElement(By.id("fq-main-menu-auth" )).click();
		
			
		
		//Test Following
		//login with empty fields
				loginWithEmptyFields();
								
		//login with invalid username and invalid password
				invalidUserNameAndInvalidPassword();
				
		//login with correct username and wrong password
				 ValidUsernameInvalidPassword();
				 
		//login with correct username and blank/clear password	
				  ValidUsernameBlankPassword();
				  
		//login with correct username and without/space password
				    ValidUsernameNoPassword() ; 
				    
		//login with invalid username and	valid password	    
				    invalidUsernameAndValidPassword();
				    
		//login with valid username and valid password
				    validUsernameAndValidPassword();
		}

	}


