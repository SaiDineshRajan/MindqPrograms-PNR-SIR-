package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test22 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		//drag and drop
		WebElement e1=driver.findElement(By.id("draggable"));
		WebElement e2=driver.findElement(By.id("droppable"));
		Actions a=new Actions(driver);
		a.dragAndDrop(e1,e2).build().perform();

	}

}



