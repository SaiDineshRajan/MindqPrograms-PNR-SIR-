package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test25
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to open browser                    
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get(
			 "https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//Automate multi-select drop-down
		WebElement e=driver.findElement(By.xpath(
				"(//*[contains(@class,'fluid dropdown')])[1]"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(5000);
		a.sendKeys("a").build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		a.sendKeys("c").build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		//De-select all items
		for(int i=4;i>=3;i--)
		{
			driver.findElement(By.xpath("(//*[contains(@class,'fluid dropdown')])[1]/child::*["+i+"]/child::*")).click();
		}
		
		
		
		
		
		
		
		

	}

}
