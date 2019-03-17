package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Test19
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.flipkart.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				     "//*[@class='_2AkmmA _29YdH8']")).click();
		Thread.sleep(5000);
		//Place mouse pointer on Women link
		WebElement e=driver.findElement(By.xpath(
				                      "//*[text()='Women']"));
		Actions a=new Actions(driver);
		a.moveToElement(e).build().perform();
		

	}
}
