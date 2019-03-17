package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test17
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver",
				              "E:\\batch236\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Thread.sleep(5000);
		//Switch to frame
		driver.switchTo().frame("iframeResult");
		//Select items in multi-select drop-down
		WebElement e=driver.findElement(By.name("cars"));
		Select s=new Select(e);
		Actions a=new Actions(driver);
		a.keyDown(Keys.CONTROL).build().perform();
		a.click(s.getOptions().get(2)).build().perform();
		a.click(s.getOptions().get(3)).build().perform();
		a.keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(10000);
		String x=s.getFirstSelectedOption().getText();
		System.out.println(x);
		List<WebElement> l=s.getAllSelectedOptions();
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		
		
		
		
		
		
		
		
		
		
		
		//Back to page
		driver.switchTo().defaultContent(); 
		//Close site
		driver.close();

	}

}



