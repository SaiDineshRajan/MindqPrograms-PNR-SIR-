package stevejobs;

import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test119
{
	public static void main(String[] args) throws Exception
	{
		//Get multiple words from keyboard
		Scanner sc=new Scanner(System.in);
		ArrayList<String> a=new ArrayList<String>();
		System.out.println("Enter limit");
		int l=Integer.parseInt(sc.nextLine());
		System.out.println("Enter "+l+" no: of words");               
		for(int i=0;i<l;i++)
		{
			a.add(sc.nextLine());
		}
		//Create results file
		ExtentReports er=new ExtentReports("googleres.html",
                                                     false);
		ExtentTest et=er.startTest("Google Title Test");
		//Data driven testing
		for(int i=0;i<l;i++)
		{
			//Launch site                    
			System.setProperty("webdriver.chrome.driver",
					"E:\\batch236\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://www.google.co.in");
			driver.manage().window().maximize();
			Thread.sleep(5000);
			//Search a word
			driver.findElement(By.name("q")).sendKeys(
										a.get(i),Keys.ENTER);
			Thread.sleep(5000);
			//Validation
			int flag=0;
			while(2>1) //infinite loop
			{
				String t=driver.getTitle();
				if(!(t.contains(a.get(i))))
				{
					flag=1;
				}
				//Goto next page
				try
				{
					if(driver.findElement(By.xpath(
						"//*[text()='Next']")).isDisplayed())
					{
						driver.findElement(By.xpath(
							"//*[text()='Next']")).click();
						Thread.sleep(3000);
					}
				}
				catch(Exception ex)
				{
					break; //to terminate from loop
				}
			}
			if(flag==0)
			{
				et.log(LogStatus.PASS,a.get(i)+" Test passed");
			}
			else
			{
				et.log(LogStatus.FAIL,a.get(i)+" Test failed");               
			}
			//Close site
			driver.close();
		}
		//Save and close results
		er.endTest(et);
		er.flush();
	}
}
