package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test36 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver",
				  "E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get tool tip value of element in Ist way
		String x=driver.findElement(By.xpath("//*[@id='hplogo']/descendant::*[2]")).getAttribute("title");
		System.out.println(x);
		//Get tool tip value of element in IInd way
		WebElement e=driver.findElement(By.xpath("//*[@id='hplogo']/descendant::*[2]"));
		Actions a=new Actions(driver);
		a.moveToElement(e).build().perform();
		Thread.sleep(5000);
		WebElement tte=driver.findElement(By.xpath("//*[contains(text(),'135th Birthday')]"));
		String y=tte.getText();
		System.out.println(y);
		driver.close();
		
		
	}

}




