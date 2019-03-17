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

public class Test102 
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//Create results file(.html)
		ExtentReports er=new ExtentReports("googleres.html",
				                                     false);
		ExtentTest et=er.startTest("Google Title Test");
		//Run browser driver to get browser(Java)                    
		System.setProperty("webdriver.chrome.driver",
					"E:\\batch236\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Search a word
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(5000);
		//Validation
		int flag=0;
		while(2>1)
		{
			String y=driver.getTitle();
			if(!(y.contains(x)))
			{
				flag=1;
			}
			//next page
			try
			{
				if(driver.findElement(By.xpath(
						"//*[text()='Next']")).isDisplayed())
				{
					driver.findElement(By.xpath(
							"//*[text()='Next']")).click();
					Thread.sleep(5000);
				}
			}
			catch(Exception ex)
			{
				break; //to terminate from loop
			}
		}
		if(flag==0)
		{
			et.log(LogStatus.PASS,"Test passed");
		}
		else
		{
			et.log(LogStatus.FAIL,"Test failed");               
		}
		//Close site
		driver.close();
		//Save and close results
		er.endTest(et);
		er.flush();
	}
}
