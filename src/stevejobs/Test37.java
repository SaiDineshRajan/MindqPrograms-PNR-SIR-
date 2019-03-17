package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test37
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver",
				  "E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get all elements in page
		List<WebElement> l=driver.findElements(By.xpath("//*"));
		System.out.println(l.size());
		//Check each element for tool tip(title attribute)
		int c=0;
		for(int i=0;i<l.size();i++)
		{
			try
			{
				if(l.get(i).getAttribute("title")!=null)
				{
					c=c+1;
				}
			}
			catch(Exception ex)
			{
				continue;
			}
		}
		System.out.println(c);
		driver.close();
	}
}
