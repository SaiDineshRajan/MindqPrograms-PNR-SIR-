package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test32
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver",
					"E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Click a link and wait for complete operation
		driver.findElement(By.linkText("4")).click();
		WebDriverWait w=new WebDriverWait(driver,100); 
		w.until(ExpectedConditions.
		  invisibilityOfElementLocated(
				  By.className("raDiv")));
		//Close site
		driver.close();
	}
}




