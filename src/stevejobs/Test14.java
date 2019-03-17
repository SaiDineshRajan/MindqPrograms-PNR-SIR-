package stevejobs;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test14
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
	               "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Make screen shot
		File src=((TakesScreenshot)driver).getScreenshotAs(
				                           OutputType.FILE);
		File dest=new File("E:\\batch236\\screenshot.png");
		FileUtils.copyFile(src,dest);
		//Close site
		driver.close();
	}
}







