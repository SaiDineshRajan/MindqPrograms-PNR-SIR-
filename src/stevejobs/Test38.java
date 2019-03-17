package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test38
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver",
				  "E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Enter user-id
		driver.findElement(By.name("userName"))
									.sendKeys("abdulkalam");
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		WebElement e=driver.findElement(By.name("userName"));
		a.click(e).keyDown(Keys.CONTROL).build().perform();
		a.sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		a.keyDown(Keys.CONTROL).build().perform();
		a.sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(5000);
		a.keyDown(Keys.CONTROL).build().perform();
		a.sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		
		
		

	}

}
