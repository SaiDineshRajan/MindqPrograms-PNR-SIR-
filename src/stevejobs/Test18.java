package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test18
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		System.setProperty("webdriver.chrome.driver",
	              "E:\\batch236\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(dc);
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.name("q"));
		Actions a=new Actions(driver);
		a.contextClick(e).build().perform();
	}

}
