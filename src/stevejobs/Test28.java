package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test28
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to open browser                    
		System.setProperty("webdriver.chrome.driver",
				   "E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get(
			   "https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//scroll to bottom
		js.executeScript(
			 "window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(5000);
		//scroll to top
		js.executeScript(
			  "window.scrollTo(document.body.scrollHeight,0);");
		Thread.sleep(5000);
		//Scroll to specific element in page
		WebElement e=driver.findElement(By.xpath(
				               "//*[text()='Select Country']"));
		js.executeScript("arguments[0].scrollIntoView();",e);
		Thread.sleep(5000);
		
		
	

	}

}
