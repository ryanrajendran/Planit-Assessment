package Packone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Testcasefour {

	WebDriver driver;
	
	//Code for step 1: From the home page to shop page

	
	public void Launchbrowser() 

	{
			
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://jupiter.cloud.planittesting.com");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
			
	}
	
	//Code for steps 2 and 3: Buying items and going to cart

	public void Buying()
			
	{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//body/div[2]/div[1]/ul[1]/li[6]/div[1]/p[1]/a[1]")).click();
			driver.findElement(By.xpath("//body/div[2]/div[1]/ul[1]/li[6]/div[1]/p[1]/a[1]")).click();
			driver.findElement(By.xpath("//body/div[2]/div[1]/ul[1]/li[4]/div[1]/p[1]/a[1]")).click();
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[2]/li[4]/a[1]")).click();
			
			
	}
	
	//Code for step 4: Verifying items in the cart

	public void Checkbuy() 

	{
		
		
		if((driver.getPageSource().contains("Funny Cow")) && (driver.getPageSource().contains("Fluffy Bunny"))) 
		{
			System.out.println("Funny Cow and Fluffy Bunny are present in the cart");
		}

		else
		{
			System.out.println("Discrepancy or error in shopping cart");
		}
		
		String Cow = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]")).getAttribute("value");
		System.out.println("The number of Funny Cow : "+ Cow);
		
		String Bunny = driver.findElement(By.xpath("//tbody/tr[2]/td[3]/input[1]")).getAttribute("value");
		System.out.println("The number of Fluffy Bunny : "+ Bunny);
		
		
	}
	
public static void main(String[] args) 
{
	
Testcasefour obj = new Testcasefour();
		
		obj.Launchbrowser();
		obj.Buying();
		obj.Checkbuy();
}

}
