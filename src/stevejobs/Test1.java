package stevejobs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test1
{
	public static void main(String[] args)
	{
		//run browser driver to get browse window
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
	}
}
