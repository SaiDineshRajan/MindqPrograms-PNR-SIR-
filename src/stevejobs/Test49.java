package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test49
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter input1");
		String x=sc.nextLine();
		System.out.println("Enter input2");
		String y=sc.nextLine();
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Details for ARD and app under testing
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","6.0.1");
		dc.setCapability("appPackage",
				       "com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity",
			"com.sec.android.app.popupcalculator.Calculator");
		//Create driver object to launch app
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		//Operate elements in app screen
		for(int i=0;i<x.length();i++)
		{
			char d=x.charAt(i);
			driver.findElement(By.xpath(
					          "//*[@text='"+d+"']")).click();
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath(
			 "//*[@content-desc='plus'][@index='6']")).click();
		Thread.sleep(10000);
		for(int i=0;i<y.length();i++)
		{
			char d=y.charAt(i);
			driver.findElement(By.xpath(
					"//*[@text='"+d+"']")).click();
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath(
			"//*[@content-desc='equal'][@index='6']")).click();
		Thread.sleep(10000);
		String actual=driver.findElement(By.xpath(
		  "//*[@class='android.widget.EditText'][@index='0']"))
		  .getAttribute("text");
		actual=actual.replace(",",""); //remove , in output
		//convert inputs and output to integers
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		int c=Integer.parseInt(actual);
		if(c==a+b)
		{
			System.out.println("Addition test passed");
		}
		else
		{
			System.out.println("Addition test failed");
			DateFormat df=new 
					   SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		    Date d=new Date();
		    String imagename=df.format(d);//today date with time
			File f=driver.getScreenshotAs(OutputType.FILE);
			File s=new File("E:\\batch236\\"+imagename+".png");
			FileUtils.copyFile(f,s);
		}
		driver.findElement(By.xpath(
			"//*[@content-desc='clear'][@index='0']")).click();
		Thread.sleep(10000);
		//close app
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}







