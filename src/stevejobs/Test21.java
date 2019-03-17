package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test21
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Enter data to auto-complete and select specific one
		WebElement e=driver.findElement(By.name("q"));
		Actions a=new Actions(driver);
		a.sendKeys(e,"kalam").build().perform();
		Thread.sleep(5000);
		for(;;) //infinite loop
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(3000);
			String x=e.getAttribute("value");
			if(x.equalsIgnoreCase("kalam quotes"))
			{
				break; //stop loop
			}
		}
		a.sendKeys(Keys.ENTER).build().perform();
		
		
		
		
	}

}




