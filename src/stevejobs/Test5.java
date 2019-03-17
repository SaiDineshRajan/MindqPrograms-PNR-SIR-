package stevejobs;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test5
{
	public static void main(String[] args) throws InterruptedException 
	{
		//run browser driver to get browser window
		System.setProperty("webdriver.chrome.driver",
							"E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get(
			  "http://site24.way2sms.com/content/index.html");
		Thread.sleep(5000);
		//Click on google play store
		driver.findElement(By.xpath(
		  "//*[contains(@src,'android-button.png')]")).click();
		Thread.sleep(5000);
		//get browser windows handle values
		ArrayList<String> a=new ArrayList<String>(
				                    driver.getWindowHandles());
		//Goto google play store browser window/tab
		driver.switchTo().window(a.get(1));
		//Do searching
		driver.findElement(By.name("q")).sendKeys("kalam",Keys.ENTER);
		Thread.sleep(5000);
		//Close google play store browser window
		driver.close();
		Thread.sleep(5000);
		//Back to way2sms browser window/tab
		driver.switchTo().window(a.get(0));
		//Do login
		driver.findElement(By.name("username"))
		                         .sendKeys("8147572689");
		driver.findElement(By.name("password"))
		                         .sendKeys("9959961228");
		driver.findElement(By.id("loginBTN")).click();
		Thread.sleep(5000);
		//Close way2sms site
		driver.close();
	}
}






