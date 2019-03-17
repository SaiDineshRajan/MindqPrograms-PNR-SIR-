package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test8
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
			    "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://site21.way2sms.com/content/index.html?");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("username")).sendKeys("72689");
		driver.findElement(By.name("password")).sendKeys("9959961228");
		driver.findElement(By.id("loginBTN")).click();
		Thread.sleep(5000);
		//Handle web-alert
		String x=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(x);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}






