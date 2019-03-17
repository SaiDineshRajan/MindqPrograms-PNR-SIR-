package stevejobs;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Test106
{
	public static void main(String[] args) throws Exception
	{
		//Create results file(.html)
		ExtentReports er=new ExtentReports("gmailres.html",
				                                    false);
		ExtentTest et=er.startTest("Gmail mails deletion Test");
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver",
				           "E:\\batch236\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier"))
		                          .sendKeys("vinayisb4u");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password"))
		                          .sendKeys("vinay@1993");
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(20000);
		//Go to first page of mailbox by clicking inbox link
		driver.findElement(By.xpath(
			"(//*[contains(text(),'Inbox (')])[2]")).click();
		Thread.sleep(10000);
		//Get actual count of total mails before delete
		String actualbd=driver.findElement(By.xpath(
			 "//*[@aria-label='Newer']/preceding::span[1]"))
			 .getText();
		actualbd=actualbd.replace(",","");
		int atcbd=Integer.parseInt(actualbd);
		System.out.println(atcbd);
		//Goto mails for deletion via pagination
		int dmc=0;
		while(2>1)  //infinite loop
		{
			WebElement mailbox=driver.findElement(By.xpath(
		 "(//*[@role='tabpanel'])[1]/descendant::table/tbody"));
			List<WebElement> rows=mailbox.findElements(
					                          By.tagName("tr"));
			for(int i=0;i<rows.size();i++)
			{
				driver.navigate().refresh();
				mailbox=driver.findElement(By.xpath(
				"(//*[@role='tabpanel'])[1]/descendant::table/tbody"));
				Thread.sleep(10000);
				rows=mailbox.findElements(By.tagName("tr"));
				Thread.sleep(10000);
				List<WebElement> cols=rows.get(i).findElements(
						                             By.tagName("td"));
				String tt=cols.get(7).findElement(By.tagName("span"))
						                       .getAttribute("title");
				if(tt.contains("Jan") && tt.contains("2018"))
				{
					cols.get(1).findElement(By.className("T-Jo-auh"))
					                                          .click();
					Thread.sleep(10000);
					driver.findElement(By.xpath(
				  "(//*[@class='G-Ni J-J5-Ji'])[2]/child::div[3]"))
					  .click();
					Thread.sleep(10000);
					i=i-1; //to check next when it came to current pos
					dmc=dmc+1;
				}
			}
			//Go to next page
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
				Thread.sleep(10000);
			}
		}
		//Get actual count of total mails after delete
		String actualad=driver.findElement(By.xpath(
				 "//*[@aria-label='Newer']/preceding::span[1]"))
				 .getText();
		actualad=actualad.replace(",","");
		int atcad=Integer.parseInt(actualad);
		System.out.println(atcad);
		//validation
		if(atcbd==atcad+dmc)
		{
			et.log(LogStatus.PASS,"Mails deletion Test passed");
		}
		else
		{
			et.log(LogStatus.FAIL,
					"Mails deletion test failed");
			et.log(LogStatus.FAIL,atcbd+" "+atcad+" "+dmc);
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
