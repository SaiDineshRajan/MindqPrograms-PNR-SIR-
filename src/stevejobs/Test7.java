package stevejobs;
import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.sun.glass.events.KeyEvent;

public class Test7 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
				    "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get(
				"http://site21.way2sms.com/content/index.html");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("username"))
		                             .sendKeys("8147572689");
		driver.findElement(By.name("password"))
		                              .sendKeys("9959961228");
		driver.findElement(By.id("loginBTN")).click();
		Thread.sleep(5000);
		//Click on Send SMS
		driver.findElement(By.xpath("//*[text()='Send SMS']"))
										.click();
		Thread.sleep(5000);
		//Fill fields and click send button
		driver.switchTo().frame("frame"); //Switch to frame
		driver.findElement(By.name("mobile"))
		                         .sendKeys("7661973143");
		driver.findElement(By.name("message"))
		                         .sendKeys("Happy new year");
		driver.findElement(By.name("Send")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();//Back to page
		try
		{
			if(driver.findElement(
			By.xpath("//*[text()='Install Chrome Plugin']"))
			.isDisplayed())
			{
				driver.findElement(By.xpath(
						"//*[text()='Install Chrome Plugin']"))
						.click();
				Thread.sleep(5000);
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(5000);
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(5000);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);	
				Thread.sleep(5000);
			}
		}
		catch(Exception ex)
		{
		}
		//Get msg and display
		driver.switchTo().frame("frame");//switch to frame
		String x=driver.findElement(By.xpath("(//*[contains(@class,'ssms')])[6]/following-sibling::*")).getText();
		System.out.println(x);
		//Do logout
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@class='out louti']"))
		                                             .click();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}






