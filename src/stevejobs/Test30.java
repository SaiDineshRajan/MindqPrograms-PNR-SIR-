package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test30
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch236\\chromedriver.exe");
		ChromeDriver driver1=new ChromeDriver();
		
		System.setProperty("webdriver.ie.driver","E:\\batch236\\iedriverserver.exe");
		InternetExplorerDriver driver2=new InternetExplorerDriver();
		
		System.setProperty("webdriver.gecko.driver","E:\\batch236\\geckodriver.exe");
		FirefoxDriver driver3=new FirefoxDriver();
	}

}
