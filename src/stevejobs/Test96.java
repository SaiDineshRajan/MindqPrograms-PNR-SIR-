package stevejobs;
import java.io.File;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Test96 
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter mobile number");
		String m=sc.nextLine();
		System.out.println("Enter mobile number criteria");
		String mc=sc.nextLine();
		System.out.println("Enter Password");
		String p=sc.nextLine();
		System.out.println("Enter Password criteria");
		String pc=sc.nextLine();
		//Create results file(.html)
		ExtentReports er=new ExtentReports(
				                 "w2smsres.html",false);
		ExtentTest et=er.startTest("W2SMS Login Test");
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver",
					       "E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get(
				"http://site21.way2sms.com/content/index.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("username")).sendKeys(m);
		driver.findElement(By.name("password")).sendKeys(p);
		driver.findElement(By.id("loginBTN")).click();
		Thread.sleep(5000);
		//Validations
		try
		{
		   if(m.length()==0 && 
		   ExpectedConditions.alertIsPresent()!=null)
		   {
			et.log(LogStatus.PASS,
					"Test passed for blank mobile number");
		   }
		   else if(m.length()<10 && 
		   ExpectedConditions.alertIsPresent()!=null)
		   {
			et.log(LogStatus.PASS,
				"Test passed for wrong size of mobile number");
		   }
		   else if(p.length()==0 && 
		   ExpectedConditions.alertIsPresent()!=null)
		   {
			et.log(LogStatus.PASS,"Test passed for blank password");
		   }
		   else if(mc.equalsIgnoreCase("invalid") &&
			driver.findElement(By.xpath(
			"//*[contains(text(),'registered yet')]"))
			.isDisplayed())
		   {
			et.log(LogStatus.PASS,
					"Test passed for invalid mobile number");
		   }
		   else if(mc.equalsIgnoreCase("valid") && 
				pc.equalsIgnoreCase("invalid")
				&& driver.findElement(By.xpath(
				"//*[contains(text(),'Forgot Password')]"))
				.isDisplayed())
		   {
			et.log(LogStatus.PASS,
					     "Test passed for invalid Password");
		   }
		   else if(mc.equalsIgnoreCase("valid") && 
				pc.equalsIgnoreCase("valid") &&
				driver.findElement(By.xpath(
				"//*[text()='Send SMS']")).isDisplayed())
		   {
			et.log(LogStatus.PASS,"Test passed for valid data");
		   }
		   else
		   {
			File src=((TakesScreenshot)driver).getScreenshotAs(
                    OutputType.FILE);
			File dest=new File("ss.png");
			FileUtils.copyFile(src,dest);
			et.log(LogStatus.FAIL,"Test failed");
			et.log(LogStatus.FAIL,et.addScreenCapture("ss.png"));
		   }
		}
		catch(Exception ex)
		{
			et.log(LogStatus.ERROR,"Exception was raised");
		}
		//Close site
		driver.close();
		//Save results
		er.endTest(et);
		er.flush();
	}
}






