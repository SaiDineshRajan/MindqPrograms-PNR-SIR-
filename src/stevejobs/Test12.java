package stevejobs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test12
{
	public static void main(String[] args) throws InterruptedException
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
	               "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Delete all existing cookies
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		//Cookies testing
		if(driver.manage().getCookies().size()!=0)
		{
			System.out.println("Cookies were loaded");
		}
		else
		{
			System.out.println("Cookies were not loaded");
		}
		//Close site
		driver.close();
	}

}



