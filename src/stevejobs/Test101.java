package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Test101 
{
	public static void main(String[] args) throws Exception
	{
		//Create results file(.html)
		ExtentReports er=new ExtentReports("gmailres.html",false);
		ExtentTest et=er.startTest("Gmail mails count Test");
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver","E:\\batch236\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier"))
		                          .sendKeys("sunil.komandala");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password"))
		                          .sendKeys("dadmom@1216");
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(10000);
		//Go to first page of mailbox
		driver.findElement(By.xpath(
			"(//*[contains(text(),'Inbox (')])[2]")).click();
		Thread.sleep(10000);
		//Get actual count of total mails
		String actual=driver.findElement(By.xpath(
			 "//*[@aria-label='Newer']/preceding::span[1]"))
			 .getText();
		actual=actual.replace(",","");
		int atc=Integer.parseInt(actual);
		System.out.println(atc);
		//Count total mails via pagination
		int etc=0;
		while(2>1)  //infinite loop
		{
			WebElement mailbox=driver.findElement(By.xpath(
		 "(//*[@role='tabpanel'])[1]/descendant::table/tbody"));
			int mc=mailbox.findElements(By.tagName("tr"))
					                             .size();
			etc=etc+mc;
			try
			{
				String x=driver.findElement(By.xpath(
					     "//*[@aria-label='Older']"))
					     .getAttribute("aria-disabled");
				if(x.equals("true"))
				{
					break;  //to terminate from infinite loop
				}
			}
			catch(Exception ex)
			{
				driver.findElement(By.xpath(
						"//*[@aria-label='Older']")).click();
				Thread.sleep(5000);
			}
		}
		System.out.println(etc);
		//validation
		if(atc==etc)
		{
			et.log(LogStatus.PASS,
					"Mailbox total mails count Test passed");
		}
		else
		{
			et.log(LogStatus.FAIL,
					"Mailbox total mails count test failed");
			et.log(LogStatus.FAIL, atc+" "+etc);
		}
		//Do logout and close site
		driver.findElement(By.xpath(
		 "//*[contains(@title,'Google Account')]/child::span"))
		 .click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		driver.close();
		//Save results
		er.endTest(et);
		er.flush();
	}
}
