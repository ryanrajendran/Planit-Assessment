package Packone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Testcasetwo {
	
	WebDriver driver;
	
	//Code for step 1: From the home page to contact page
	
	public void Launchbrowser() 

	{
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://jupiter.cloud.planittesting.com");
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
		
		
	}


	//Code for steps 2 and 3: Populating mandatory fields and submit button click

	public void Population() 

	{
	
	WebElement textbox1 = driver.findElement(By.xpath("//input[@id='forename']"));
	textbox1.sendKeys("Ranjit");
	
	WebElement textbox2 = driver.findElement(By.xpath("//input[@id='email']"));
	textbox2.sendKeys("ranjit@gmail.com");
	
	WebElement textbox3 = driver.findElement(By.xpath("//textarea[@id='message']"));
	textbox3.sendKeys("Hi this is a test entry");
	
	driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();

	}


	//Code for step 4: Validating successful submission message
	
	public void Recheck()
	
	{
	
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'« Back')]")));
	 
	 if(driver.getPageSource().contains("we appreciate your feedback")){

		 System.out.println("Success message is shown");

		 }

		 else

		 {

		 System.out.println("Error message");

		 }


	}

public static void main(String[] args) 
	
	{
		
Testcasetwo obj = new Testcasetwo();
		
		obj.Launchbrowser();
		obj.Population();
		obj.Recheck();
	}

}
