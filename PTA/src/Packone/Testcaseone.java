package Packone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;


public class Testcaseone {
	
	WebDriver driver;
	
	//Code for steps 1 and 2: From the home page to contact and clicking on Submit button
	
	public void Launchbrowser()  
	
	{
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://jupiter.cloud.planittesting.com");    //Going to home page
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();  //Going to contact page
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();  //Clicking the Submit button

	}
	
	
	//Code for step 3: Validating that required and mandatory error messages are shown 

	public void Validation() 

	{
	
	String actualerrormessage1= driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]")).getText();
	String expectederrormessage1 = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
	Assert.assertEquals(expectederrormessage1,  actualerrormessage1);
	System.out.println ("Header red bar error message is shown and validated succesfully");
	
	String actualerrormessage2= driver.findElement(By.xpath("//span[text()='Forename is required']")).getText();
	String expectederrormessage2 = "Forename is required";
	Assert.assertEquals(expectederrormessage2,  actualerrormessage2);
	System.out.println ("Forename field error message is shown and validated succesfully");
	
	String actualerrormessage3= driver.findElement(By.xpath("//span[text()='Email is required']")).getText();
	String expectederrormessage3 = "Email is required";
	Assert.assertEquals(expectederrormessage3,  actualerrormessage3);
	System.out.println ("Email field error message is shown and validated succesfully");
	
	
	String actualerrormessage4= driver.findElement(By.xpath("//span[text()='Message is required']")).getText();
	String expectederrormessage4 = "Message is required";
	Assert.assertEquals(expectederrormessage4,  actualerrormessage4);
	System.out.println ("Message field error message is shown and validated succesfully");
	

	}
	
	//Code for step 4: Populating mandatory fields 

	public void Population() 

	{
	
	WebElement textbox1 = driver.findElement(By.xpath("//input[@id='forename']"));
	textbox1.sendKeys("Ranjit");
	
	WebElement textbox2 = driver.findElement(By.xpath("//input[@id='email']"));
	textbox2.sendKeys("ranjit@gmail.com");
	
	WebElement textbox3 = driver.findElement(By.xpath("//textarea[@id='message']"));
	textbox3.sendKeys("Hi, This is a test entry.");
	
	}

	
	//Code for step 5: Validating the error messages disappear once values entered 
	
	public void Recheck()   
	{
	
			 
	String actualerrormessage1= driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]")).getText();
			String expectederrormessage1 = "We welcome your feedback - tell it how it is.";
			Assert.assertEquals(expectederrormessage1,  actualerrormessage1);
			System.out.println ("Header message in red bar is replaced by default blue bar message");
			
			
	 if(driver.getPageSource().contains("Forename is required")){

		 System.out.println("Forename field error message is still present");

		 }

		 else

		 {

		 System.out.println("Forename field error message is no longer present");

		 }
	 
	
	 if(driver.getPageSource().contains("Email is required")){

		 System.out.println("Email field error message is still present");

		 }

		 else

		 {

		 System.out.println("Email field error message is no longer present");

		 }
	 
	 if(driver.getPageSource().contains("Message is required")){

		 System.out.println("Message field error message is still present");

		 }

		 else

		 {

		 System.out.println("Message field error message is no longer present");

		 }
	 
	
	}


public static void main(String[] args) {

		Testcaseone obj = new Testcaseone();
		
		obj.Launchbrowser();
		obj.Validation();
		obj.Population();
		obj.Recheck();
	}

}
