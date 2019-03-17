package stevejobs;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
public class Test31
{
	public static void main(String[] args) throws Exception
	{
		//Get browser using keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String x=sc.nextLine();
		WebDriver driver=null;
		if(x.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"E:\\batch236\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(x.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					"E:\\batch236\\iedriverserver.exe");
			driver=new InternetExplorerDriver();
		}
		else if(x.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"E:\\batch236\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(x.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver",
				"E:\\batch236\\operadriver_win64\\operadriver.exe");
			driver=new OperaDriver();
		}
		else
		{
			System.out.println("Unknown browser");
			System.exit(0); //stop execution
		}
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//disable
		WebElement e=driver.findElement(By.name("q"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('disabled',true);",e);
		Thread.sleep(5000);
		js.executeScript("arguments[0].removeAttribute('disabled');",e);
		Thread.sleep(5000);
		driver.quit();
	}
}
