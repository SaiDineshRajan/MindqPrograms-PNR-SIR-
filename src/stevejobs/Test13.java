package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test13
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
	               "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		driver.navigate().to("http://www.gmail.com");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.close();

	}

}
