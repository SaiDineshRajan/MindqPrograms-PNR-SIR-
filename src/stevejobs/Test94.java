package stevejobs;
import java.io.File;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Test94
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//Create results file(.html)
		ExtentReports er=new ExtentReports("googleres.html",false);
		ExtentTest et=er.startTest("Google Title Test");
		//Run browser driver to get browser(Java)                    
		System.setProperty("webdriver.chrome.driver",
					"E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Search word
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(5000);
		//Validation
		String y=driver.getTitle();
		if(y.contains(x))
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File("ss.png");
			FileUtils.copyFile(src,dest);
			et.log(LogStatus.PASS,"Google title test passed");
			et.log(LogStatus.PASS,et.addScreenCapture("ss.png"));
		}
		else
		{
			et.log(LogStatus.FAIL,"Google title test failed");
		}
		//Close site
		driver.close();
		//Save and close results
		er.endTest(et);
		er.flush();
		//Open results file
		WebDriver res=new ChromeDriver();
		res.get("file:///E:/batch236/abdulkalam/googleres.html");
		res.manage().window().maximize();
		Thread.sleep(5000);
	}
}




