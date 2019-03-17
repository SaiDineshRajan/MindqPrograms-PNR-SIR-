package stevejobs;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Test95
{
	public static void main(String[] args) throws Exception
	{
		//Create results file(.html)
		ExtentReports er=
				  new ExtentReports("gmailres.html",false);
		ExtentTest et=er.startTest("Gmail home page Test");
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver",
					"E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Validation
		try
		{
			if(driver.findElement(By.name("identifier"))
					                     .isDisplayed())
			{
				et.log(LogStatus.PASS,"Test passed");
			}
		}
		catch(Exception ex)
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(
					                           OutputType.FILE);
			File dest=new File("ss.png");
			FileUtils.copyFile(src,dest);
			et.log(LogStatus.FAIL,"Test failed");
			et.log(LogStatus.FAIL,et.addScreenCapture("ss.png"));
		}
		//Close site
		driver.close();
		//Save results file(.html)
		er.endTest(et);
		er.flush();
		//Open results file
		WebDriver res=new ChromeDriver();
		res.get("file:///E:/batch236/abdulkalam/gmailres.html");
		res.manage().window().maximize();
		Thread.sleep(5000);
	}
}
