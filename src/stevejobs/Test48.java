package stevejobs;
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
import io.appium.java_client.android.AndroidDriver;
public class Test48
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter input1");
		String x=sc.nextLine();
		System.out.println("Enter input2");
		String y=sc.nextLine();
		//Start appium server(CLI based)
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Provide details of AVD and app under testing
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage",
				         "com.android.calculator2");
		dc.setCapability("appActivity",
				         "com.android.calculator2.Calculator");
		//Create driver object to launch app in AVD
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		//Operate elements in app screen
		for(int i=0;i<x.length();i++)
		{
			char d=x.charAt(i);
			driver.findElement(By.xpath("//*[@text='"+d+"']"))
			                                         .click();
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath(
			"//*[@content-desc='plus'][@index='3']")).click();
		Thread.sleep(10000);
		for(int i=0;i<y.length();i++)
		{
			char d=y.charAt(i);
			driver.findElement(By.xpath("//*[@text='"+d+"']"))
			                                         .click();
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath(
			"//*[@content-desc='equals'][@index='2']")).click();
		Thread.sleep(10000);
		String actual=driver.findElement(By.xpath(
		  "//*[@class='android.widget.EditText'][@index='0']"))
		  .getAttribute("text");
		//convert inputs and output to integers
		int z=Integer.parseInt(actual);
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		if(z==a+b)
		{
			System.out.println("Addition test passed");
		}
		else
		{
			System.out.println("Addition test failed");
			DateFormat df=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		    Date d=new Date();
		    String imagename=df.format(d); //today date with time
			File f=driver.getScreenshotAs(OutputType.FILE);
			File s=new File("E:\\batch236\\"+imagename+".png");
			FileUtils.copyFile(f,s);
		}
		//close app 
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}







