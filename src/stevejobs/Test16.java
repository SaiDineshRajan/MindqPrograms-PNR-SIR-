package stevejobs;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Test16
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
		//Get items in specific drop-down to display
		WebElement e=driver.findElement(By.name("nights"));
		Select s=new Select(e);
		if(s.isMultiple())
		{
			System.out.println("Multi select");
		}
		else
		{
			System.out.println("Single select");
		}
		List<WebElement> l=s.getOptions();
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		//Close site
		driver.close();
	}
}
