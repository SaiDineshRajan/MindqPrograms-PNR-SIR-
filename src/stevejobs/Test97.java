package stevejobs;

import java.io.File;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test97
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Userid");
		String u=sc.nextLine();
		System.out.println("Enter Userid criteria");
		String uc=sc.nextLine();
		String p=null;
		String pc=null;
		if(uc.equalsIgnoreCase("valid"))
		{
			System.out.println("Enter Password");
			p=sc.nextLine();
			System.out.println("Enter Password criteria");
			pc=sc.nextLine();
		}
		//Create results file(.html)
		ExtentReports er=new ExtentReports(
				                 "gmailres.html",false);
		ExtentTest et=er.startTest("Gmail Login Test");
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver",
					       "E:\\batch236\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Enter userid and click next
		driver.findElement(By.name("identifier")).sendKeys(u);
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		//Userid validations
		try
		{
		if(u.length()==0 && driver.findElement(By.xpath(
			"//*[contains(text(),'Enter an email')]"))
			.isDisplayed())
		{
			et.log(LogStatus.PASS,"Userid blank test passed");
		}
		else if(uc.equalsIgnoreCase("invalid") && 
				driver.findElement(By.xpath(
			  "(//*[contains(text(),'find your Google')])[2]"))
				.isDisplayed())
		{
			et.log(LogStatus.PASS,"Invalid Userid test passed");
		}
		else if(uc.equalsIgnoreCase("valid") && 
				driver.findElement(By.name("password"))
				.isDisplayed())
		{
			et.log(LogStatus.PASS,"Valid Userid test passed");
			//Enter password and click next
			driver.findElement(By.name("password")).sendKeys(p);
			driver.findElement(By.id("passwordNext")).click();
			Thread.sleep(5000);
			//Password validation
			if(p.length()==0 && 
			   driver.findElement(By.xpath(
			   "//*[text()='Enter a password']"))
			   .isDisplayed())
			{
				et.log(LogStatus.PASS,"Blank pwd test passed");
			}
			else if(pc.equalsIgnoreCase("invalid") &&
					driver.findElement(By.xpath(
				"//*[contains(text(),'Wrong password')]"))
					.isDisplayed())
			{
				et.log(LogStatus.PASS,"Invalid pwd test passed");
			}
			else if(pc.equalsIgnoreCase("valid") &&
					driver.findElement(By.xpath(
					"//*[text()='COMPOSE']"))
					.isDisplayed())
			{
				et.log(LogStatus.PASS,"Valid pwd test passed");
			}
			else
			{
				File src=((TakesScreenshot)driver).getScreenshotAs(
	                    						  OutputType.FILE);
				File dest=new File("ss.png");
				FileUtils.copyFile(src,dest);
				et.log(LogStatus.FAIL,"Pwd Test failed");
				et.log(LogStatus.FAIL,et.addScreenCapture("ss.png"));
			}
		}
		else
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(
					  OutputType.FILE);
			File dest=new File("us.png");
			FileUtils.copyFile(src,dest);
			et.log(LogStatus.FAIL,"Userid Test failed");
			et.log(LogStatus.FAIL,et.addScreenCapture("us.png"));
		}
		}
		catch(Exception ex)
		{
			et.log(LogStatus.ERROR,"Test was interrupted");
		}
		//Close site
		driver.close();
		//Save results
		er.endTest(et);
		er.flush();
		

	}

}




