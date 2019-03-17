package stevejobs;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test15 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
	               "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.mercurytravels.co.in");
		Thread.sleep(5000);
		//Collect drop downs developed using select tag
		List<WebElement> l=driver.findElements(
				                 By.tagName("select"));
		int count=0;
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).isDisplayed())
			{
				count=count+1;
			}
		}
		System.out.println(count);
		//Close site
		driver.close();
		

	}

}
