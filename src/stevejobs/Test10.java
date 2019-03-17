package stevejobs;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test10
{
	public static void main(String[] args) throws InterruptedException
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
			    "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(5000);
		//Collect all links
		List<WebElement> l=driver.findElements(By.tagName("a"));
		System.out.println(l.size());
		driver.close();
	}
}



