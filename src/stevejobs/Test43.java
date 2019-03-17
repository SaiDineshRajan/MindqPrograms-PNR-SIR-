package stevejobs;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.sun.glass.events.KeyEvent;

public class Test43 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser(Java)                    
		System.setProperty("webdriver.chrome.driver",
					"E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser(SWD)
		WebDriver driver=new ChromeDriver();
		//Launch site(SWD)
		driver.get("http://www.seleniumhq.org");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.linkText("Download"));
		Actions a=new Actions(driver);
		a.contextClick(e).build().perform();
		Thread.sleep(5000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//Close browser windows
		driver.quit();
		
		

	}

}
