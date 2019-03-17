package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2
{
	public static void main(String[] args) throws InterruptedException 
	{
		//run browser driver to get browser window
		System.setProperty("webdriver.chrome.driver",
					"chromedriver.exe");
		//create driver object to access that browser window
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//get title 
		String t=driver.getPageSource();
		System.out.println(t);
		//Close site
		driver.close();
		

	}

}



