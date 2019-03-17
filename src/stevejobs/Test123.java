package stevejobs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class Test123
{
	public static void main(String[] args) throws Exception
	{
		//Open data file in read mode
		File f1=new File("w2smstestdata.txt");
		FileReader fr=new FileReader(f1);
		BufferedReader br=new BufferedReader(fr);               
		//Open results file for writing
		File f2=new File("w2smstestresults.txt");
		FileWriter fw=new FileWriter(f2);
		BufferedWriter bw=new BufferedWriter(fw);
		//Data driven testing
		String l=null;
		while((l=br.readLine())!=null)
		{
			String[] x=l.split(",");
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
			                           .sendKeys(x[0]);
			driver.findElement(By.name("password"))
			                            .sendKeys(x[2]);
			driver.findElement(By.id("loginBTN")).click();
			Thread.sleep(5000);
			//Validations
			try
			{
				if(x[0].length()==0 && 
				  ExpectedConditions.alertIsPresent()!=null)
				{
					bw.write("Test passed for blank mobile number");
					bw.newLine();
				 }
				 else if(x[0].length()<10 && 
				   ExpectedConditions.alertIsPresent()!=null)
				 {
					bw.write("Test passed for wrong size of mobile number");
					bw.newLine();
				 }
				 else if(x[2].length()==0 && 
				   ExpectedConditions.alertIsPresent()!=null)
				 {
					bw.write("Test passed for blank password");
					bw.newLine();
				 }
				 else if(x[1].equalsIgnoreCase("invalid") &&
					driver.findElement(By.xpath(
					"//*[contains(text(),'registered yet')]"))
					.isDisplayed())
				 {
					bw.write("Test passed for invalid mobile number");
					bw.newLine();
				 }
				 else if(x[1].equalsIgnoreCase("valid") && 
						x[3].equalsIgnoreCase("invalid")
						&& driver.findElement(By.xpath(
						"//*[contains(text(),'Forgot Password')]"))
						.isDisplayed())
				 {
					bw.write("Test passed for invalid Password");
					bw.newLine();
				}
				else if(x[1].equalsIgnoreCase("valid") && 
						x[3].equalsIgnoreCase("valid") &&
						driver.findElement(By.xpath(
						"//*[text()='Send SMS']")).isDisplayed())
				{
					bw.write("Test passed for valid data");
					bw.newLine();
				}
				else
				{
					File src=((TakesScreenshot)driver).getScreenshotAs(
		                    						  OutputType.FILE);
					File dest=new File("ss.png");
					FileUtils.copyFile(src,dest);
					bw.write("Test failed, so see ss.png");
					bw.newLine();
				}
			}
			catch(Exception ex)
			{
				bw.write("Exception was raised");
				bw.newLine();
			}
			//Close site
			driver.close();
		}
		//Close files
		br.close();
		fr.close();
		bw.close();
		fw.close();
	}
}
