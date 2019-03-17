package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test93
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser(Java)                    
		System.setProperty("webdriver.chrome.driver",
				          "E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//validation
		String x=driver.getTitle();
		if(x.equals("Google"))
		{
			System.out.println("Google title test passed");
		}
		else
		{
			System.out.println("Google title test failed");
		}
		//Close site
		driver.close();

	}

}



