package stevejobs;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
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
public class Test121 
{
	public static void main(String[] args) throws Exception
	{
		//Create two hash maps
		HashMap<String,String> uid=new HashMap<String,String>();
		HashMap<String,String> pwd=new HashMap<String,String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Eneter data limit");
		int l=Integer.parseInt(sc.nextLine());
		System.out.println("Enter test data");
		for(int i=0;i<l;i++)
		{
			System.out.println("Enter mobi no: with criteria");
			uid.put(sc.nextLine(),sc.nextLine());
			System.out.println("Enter password with criteria");
			pwd.put(sc.nextLine(),sc.nextLine());
		}
		//Create results file(.html)
		ExtentReports er=new ExtentReports("w2smsres.html",
														false);
		ExtentTest et=er.startTest("W2SMS Login Test");
		//Data driven testing
		Iterator<Entry<String,String>> i=
				                   pwd.entrySet().iterator();
		for(Entry<String,String> e1:uid.entrySet())
		{
			Entry<String,String> e2=i.next();
			//Launch site                 
			System.setProperty("webdriver.chrome.driver",
							 "E:\\batch236\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get(
				"http://site21.way2sms.com/content/index.html");
			driver.manage().window().maximize();
			Thread.sleep(5000);
			//Do login
			driver.findElement(By.name("username"))
			                           .sendKeys(e1.getKey());
			driver.findElement(By.name("password"))
			                            .sendKeys(e2.getKey());
			driver.findElement(By.id("loginBTN")).click();
			Thread.sleep(5000);
			//Validations
			try
			{
				if(e1.getKey().length()==0 && 
				  ExpectedConditions.alertIsPresent()!=null)
				{
					et.log(LogStatus.PASS,
							"Test passed for blank mobile number");
				 }
				 else if(e1.getKey().length()<10 && 
				   ExpectedConditions.alertIsPresent()!=null)
				 {
					et.log(LogStatus.PASS,
					 "Test passed for wrong size of mobile number");
				 }
				 else if(e2.getKey().length()==0 && 
				   ExpectedConditions.alertIsPresent()!=null)
				 {
					et.log(LogStatus.PASS,
							"Test passed for blank password");
				 }
				 else if(e1.getValue().equalsIgnoreCase("invalid") &&
					driver.findElement(By.xpath(
					"//*[contains(text(),'registered yet')]"))
					.isDisplayed())
				 {
					et.log(LogStatus.PASS,
							"Test passed for invalid mobile number");
				 }
				 else if(e1.getValue().equalsIgnoreCase("valid") && 
						e2.getValue().equalsIgnoreCase("invalid")
						&& driver.findElement(By.xpath(
						"//*[contains(text(),'Forgot Password')]"))
						.isDisplayed())
				 {
					et.log(LogStatus.PASS,
							     "Test passed for invalid Password");
				}
				else if(e1.getValue().equalsIgnoreCase("valid") && 
						e2.getValue().equalsIgnoreCase("valid") &&
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
		}
		//Save results
		er.endTest(et);
		er.flush();
	}
}








