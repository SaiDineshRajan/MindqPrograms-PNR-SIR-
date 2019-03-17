package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test26 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to open browser                    
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		//Enter From
		WebElement e=driver.findElement(By.id("hp-widget__sfrom"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementById('hp-widget__sfrom').click();");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@aria-label,'Top Cities : Goa')]")).click();

	}

}
