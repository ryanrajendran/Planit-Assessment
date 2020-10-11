package Packone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;


public class Testcasethree {
	
	WebDriver driver;
	
	//Code for step 1: From the home page to contact page
	
	public void Launchbrowser() 

	{
			
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://jupiter.cloud.planittesting.com");
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
			
			
	}
	
	
	//Code for step 2: Populating mandatory fields with invalid data (space in 2 cases)
	
	public void Population() 

	{
		
		WebElement textbox1 = driver.findElement(By.xpath("//input[@id='forename']"));
		textbox1.sendKeys("");
		
		WebElement textbox2 = driver.findElement(By.xpath("//input[@id='email']"));
		textbox2.sendKeys("ranjit.com");
		
		WebElement textbox3 = driver.findElement(By.xpath("//textarea[@id='message']"));
		textbox3.sendKeys(" ");
		
	}
	
	
	//Code for step 3: Validating that required and mandatory error messages are shown 
	
	public void Validation()
	{
		
		 String actualerrormessage1= driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]")).getText();
			String expectederrormessage1 = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
			Assert.assertEquals(expectederrormessage1,  actualerrormessage1);
			System.out.println ("Header red bar error message is shown and validated succesfully");
			
		 
		 if(driver.getPageSource().contains("Forename is required")){

			 System.out.println("Forename field error message is shown and validated succesfully");

			 }

			 else

			 {

			 System.out.println("Error message for Forename is absent");

			 }
		 
		
		 if(driver.getPageSource().contains("Please enter a valid email")){

			 System.out.println("Email field error message is shown and validated succesfully");

			 }

			 else

			 {

			 System.out.println("Error message for invalid Email is absent");

			 }
		 
		 if(driver.getPageSource().contains("Message is required")){

			 System.out.println("Message field error message is shown and validated succesfully");

			 }

			 else

			 {

			 System.out.println("Error message for Message is absent");

			 }
		 
	
	
	}
	
public static void main(String[] args) 
{
		
Testcasethree obj = new Testcasethree();
		
		obj.Launchbrowser();
		obj.Population();
		obj.Validation();
}

}
