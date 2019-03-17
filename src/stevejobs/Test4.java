package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4 
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
		//Get current url
		String x=driver.getCurrentUrl();
		if(x.contains("https"))
		{
			System.out.println("Secured site");
		}
		else
		{
			System.out.println("Not Secured");
		}
		//close site
		driver.close();

	}

}






