package stevejobs;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test3
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
		//get window handle of "w2sms"
		String x=driver.getWindowHandle();
		System.out.println(x);
		//Click on google play button
		driver.findElement(By.xpath(
		   "//*[@src='../images/android-button.png']")).click();
		Thread.sleep(5000);
		//get window handles of "w2sms" and "google play store"
		ArrayList<String> a=
			new ArrayList<String>(driver.getWindowHandles());
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
		//Close active browser and related browser windows/tabs
		driver.quit();

	}

}
